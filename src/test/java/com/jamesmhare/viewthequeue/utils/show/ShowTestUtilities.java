package com.jamesmhare.viewthequeue.utils.show;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.show.Show;
import com.jamesmhare.viewthequeue.utils.TestUtilities;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a utilities class to help with the saving of the shows table state at time of testing.
 */
public class ShowTestUtilities extends TestUtilities {

    private List<Show> existingShows;

    public ShowTestUtilities() {}

    /**
     * Saves a copy of the shows that currently exist in the database.
     */
    public void saveExistingShows() {
        existingShows = new ArrayList<>();
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Show/SelectAllShows.sql");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Show.Builder showBuilder = new Show.Builder()
                        .withName(rs.getString("show_name"))
                        .withDescription(rs.getString("description"))
                        .withParkName(rs.getString("park_name"))
                        .withArea(rs.getString("area"))
                        .withOperationStatus(rs.getString("operation_status"))
                        .withWheelchairAccessibility(rs.getBoolean("is_wheelchair_accessible"))
                        .withExpressLine(rs.getBoolean("has_express_line"))
                        .withShowTimes(rs.getString("show_times"));
                existingShows.add(showBuilder.build());
            }
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Restores the existing shows to the database.
     */
    public void restoreExistingShows() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            for (Show show : existingShows) {
                PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Show/InsertShow.sql");
                stmt.setString(1, show.getShowName());
                stmt.setString(2, show.getDescription());
                stmt.setString(3, show.getParkName());
                stmt.setString(4, show.getArea());
                stmt.setString(5, show.getOperationStatus());
                stmt.setBoolean(6, show.isWheelchairAccessible());
                stmt.setBoolean(7, show.isExpressLine());
                stmt.setString(8, show.getShowTimes());
                stmt.execute();
                stmt.close();
            }
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Populates the show table with test data.
     */
    public void populateShowTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Show/SetupShowData.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Drops the show table.
     */
    public void dropShowTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Show/DropShowTable.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Creates the show table.
     */
    public void createShowTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/Show/CreateShowTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

}
