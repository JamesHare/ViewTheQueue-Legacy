package com.jamesmhare.viewthequeue.model.connection.retrievers.mysql;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.connection.retrievers.AttractionRetriever;

import java.io.IOException;
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
    public List<Attraction> searchAttractionByName(String attractionName) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE attraction_name = ?");
            stmt.setString(1, attractionName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the attraction name: " + attractionName);
        } else if (attractions.size() > 1) {
            attractions.clear();
            System.out.println("More than one entry was retrieved from the database given the attraction name: " + attractionName);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractionByThemeParkName(String parkName) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE park_name = ?");
            stmt.setString(1, parkName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the Theme Park name: " + parkName);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractionByArea(String area) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE area = ?");
            stmt.setString(1, area);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the area name: " + area);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractionByOperationStatus(String operationStatus) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE operation_status = ?");
            stmt.setString(1, operationStatus);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the operation status: " + operationStatus);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractionByWheelchairAccessibility(boolean wheelchairAccessible) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE is_wheelchair_accessible = ?");
            stmt.setBoolean(1, wheelchairAccessible);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the wheelchair access: " + wheelchairAccessible);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractionByExpressLine(boolean hasExpressLine) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE has_express_line = ?");
            stmt.setBoolean(1, hasExpressLine);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the express line availability: " + hasExpressLine);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> searchAttractionBySingleRiderLine(boolean hasSingleRiderLine) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql", "WHERE has_single_rider = ?");
            stmt.setBoolean(1, hasSingleRiderLine);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the single rider line availability: " + hasSingleRiderLine);
        }
        return attractions;
    }

    /**
     * {@inheritDoc}
     */
    public List<Attraction> retrieveAllAttractions() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Attraction> attractions = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveAttraction.sql");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, attractions);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (attractions.size() == 0) {
            System.out.println("No attractions found.");
        }
        return attractions;
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
