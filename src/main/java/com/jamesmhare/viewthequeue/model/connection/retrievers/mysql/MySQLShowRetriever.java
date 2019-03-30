package com.jamesmhare.viewthequeue.model.connection.retrievers.mysql;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.connection.qualifiers.ShowQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.ShowRetriever;
import com.jamesmhare.viewthequeue.model.show.Show;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a class to retrieve {@link Show} objects from a MySQL database.
 */
public class MySQLShowRetriever implements ShowRetriever {

    public MySQLShowRetriever() {};

    /**
     * {@inheritDoc}
     */
    public List<Show> searchShows(ShowQualifier showQualifier) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Show> shows = new ArrayList<>();
        String query = buildStatement(showQualifier);
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, shows);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        return shows;
    }

    private String buildStatement(ShowQualifier showQualifier) {
        StringBuilder query = new StringBuilder("SELECT * FROM ViewTheQueueDB.shows");
        if (showQualifier.getShowName() == null) {
            query.append(" WHERE show_name LIKE '%'");
        } else {
            query.append(" WHERE show_name = '" + showQualifier.getShowName() + "'");
        }
        if (showQualifier.getParkName() == null) {
            query.append(" AND park_name LIKE '%'");
        } else {
            query.append(" AND park_name = '" + showQualifier.getParkName() + "'");
        }
        if (showQualifier.getArea() == null) {
            query.append(" AND area LIKE '%'");
        } else {
            query.append(" AND area = '" + showQualifier.getArea() + "'");
        }
        if (showQualifier.getOperationStatus() == null) {
            query.append(" AND operation_status LIKE '%'");
        } else {
            query.append(" AND operation_status = '" + showQualifier.getOperationStatus() + "'");
        }
        if (showQualifier.isExpressLine() != null) {
            query.append(" AND has_express_line = " + showQualifier.isExpressLine());
        }
        if (showQualifier.isWheelchairAccessible() != null) {
            query.append(" AND is_wheelchair_accessible = " + showQualifier.isWheelchairAccessible());
        }
        return query.toString();
    }

    private void processRow(ResultSet rs, List<Show> shows) {
        try {
            Show.Builder showBuilder = new Show.Builder()
                    .withName(rs.getString("show_name"))
                    .withDescription(rs.getString("description"))
                    .withParkName(rs.getString("park_name"))
                    .withArea(rs.getString("area"))
                    .withOperationStatus(rs.getString("operation_status"))
                    .withShowTimes(rs.getString("show_times"))
                    .withExpressLine(rs.getBoolean("has_express_line"))
                    .withWheelchairAccessibility(rs.getBoolean("is_wheelchair_accessible"));
            shows.add(showBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
