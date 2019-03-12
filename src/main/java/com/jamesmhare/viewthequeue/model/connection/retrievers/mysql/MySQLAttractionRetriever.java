package com.jamesmhare.viewthequeue.model.connection.retrievers.mysql;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.connection.qualifiers.AttractionQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.AttractionRetriever;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a class to retrieve {@link Attraction} objects from a MySQL database.
 */
public class MySQLAttractionRetriever implements AttractionRetriever {

    public MySQLAttractionRetriever() {}

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractions(AttractionQualifier attractionQualifier) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        String query = buildStatement(attractionQualifier);
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        return attractions;
    }

    private String buildStatement(AttractionQualifier attractionQualifier) {
        StringBuilder query = new StringBuilder("SELECT * FROM ViewTheQueueDB.Attractions");
        if (attractionQualifier.getAttractionName() == null) {
            query.append(" WHERE attraction_name LIKE '%'");
        } else {
            query.append(" WHERE attraction_name = '" + attractionQualifier.getAttractionName() + "'");
        }
        if (attractionQualifier.getParkName() == null) {
            query.append(" AND park_name LIKE '%'");
        } else {
            query.append(" AND park_name = '" + attractionQualifier.getParkName() + "'");
        }
        if (attractionQualifier.getArea() == null) {
            query.append(" AND area LIKE '%'");
        } else {
            query.append(" AND area = '" + attractionQualifier.getArea() + "'");
        }
        if (attractionQualifier.getOperationStatus() == null) {
            query.append(" AND operation_status LIKE '%'");
        } else {
            query.append(" AND operation_status = '" + attractionQualifier.getOperationStatus() + "'");
        }
        if (attractionQualifier.isWheelchairAccessible() != null) {
            query.append(" AND is_wheelchair_accessible = " + attractionQualifier.isWheelchairAccessible());
        }
        if (attractionQualifier.isExpressLine() != null) {
            query.append(" AND has_express_line = " + attractionQualifier.isExpressLine());
        }
        if (attractionQualifier.isSingleRider() != null) {
            query.append(" AND has_single_rider = " + attractionQualifier.isSingleRider());
        }
        return query.toString();
    }

    private void processRow(ResultSet rs, List<Attraction> attractions) {
        try {
            Attraction.Builder attractionBuilder = new Attraction.Builder()
                    .withName(rs.getString("attraction_name"))
                    .withDescription(rs.getString("description"))
                    .withParkName(rs.getString("park_name"))
                    .withArea(rs.getString("area"))
                    .withOperationStatus(rs.getString("operation_status"))
                    .withOpeningTime(rs.getString("opening_time"))
                    .withClosingTime(rs.getString("closing_time"))
                    .withWaitTime(rs.getInt("wait_time"))
                    .withMaxHeightRestrictionInInches(rs.getInt("max_height_restriction_inches"))
                    .withMinHeightRestrictionInInches(rs.getInt("min_height_restriction_inches"))
                    .withWheelchairAccessibility(rs.getBoolean("is_wheelchair_accessible"))
                    .withExpressLine(rs.getBoolean("has_express_line"))
                    .withSingleRiderLine(rs.getBoolean("has_single_rider"));
            attractions.add(attractionBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
