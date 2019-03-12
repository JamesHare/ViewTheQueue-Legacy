package com.jamesmhare.viewthequeue.utils;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import com.jamesmhare.viewthequeue.model.show.Show;
import com.jamesmhare.viewthequeue.model.themepark.ThemePark;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a utilities class to help with the saving of the database state at time of testing.
 */
public class TestUtilities {

    private List<Attraction> existingAttractions;
    private List<Restaurant> existingRestaurants;
    private List<Show> existingShows;
    private List<ThemePark> existingThemeParks;

    public TestUtilities() {}

    /**
     * Saves a copy of the attractions that currently exist in the database.
     */
    public void saveExistingAttractions() {
        existingAttractions = new ArrayList<>();
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Attraction/SelectAllAttractions.sql");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
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
                existingAttractions.add(attractionBuilder.build());
            }
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Saves a copy of the restaurants that currently exist in the database.
     */
    public void saveExistingRestaurants() {
        existingRestaurants = new ArrayList<>();
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Restaurant/SelectAllRestaurants.sql");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Restaurant.Builder restaurantBuilder = new Restaurant.Builder()
                        .withName(rs.getString("restaurant_name"))
                        .withDescription(rs.getString("description"))
                        .withParkName(rs.getString("park_name"))
                        .withArea(rs.getString("area"))
                        .withOperationStatus(rs.getString("operation_status"))
                        .withOpeningTime(rs.getString("opening_time"))
                        .withClosingTime(rs.getString("closing_time"))
                        .servesVegetarian(rs.getBoolean("serves_vegetarian"))
                        .servesVegan(rs.getBoolean("serves_vegan"));
                existingRestaurants.add(restaurantBuilder.build());
            }
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Restores the existing attractions to the database.
     */
    public void restoreExistingAttractions() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            for (Attraction attraction : existingAttractions) {
                PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Attraction/InsertAttraction.sql");
                stmt.setString(1, attraction.getAttractionName());
                stmt.setString(2, attraction.getDescription());
                stmt.setString(3, attraction.getParkName());
                stmt.setString(4, attraction.getArea());
                stmt.setString(5, attraction.getOperationStatus());
                stmt.setString(6, attraction.getOpeningTime());
                stmt.setString(7, attraction.getClosingTime());
                stmt.setInt(8, attraction.getWaitTime());
                stmt.setInt(9, attraction.getMaxHeightRestrictionInches());
                stmt.setInt(10, attraction.getMinHeightRestrictionInches());
                stmt.setBoolean(11, attraction.isWheelchairAccessible());
                stmt.setBoolean(12, attraction.isExpressLine());
                stmt.setBoolean(13, attraction.isSingleRider());
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
     * Restores the existing restaurants to the database.
     */
    public void restoreExistingRestaurants() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            for (Restaurant restaurant : existingRestaurants) {
                PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Restaurant/InsertRestaurant.sql");
                stmt.setString(1, restaurant.getRestaurantName());
                stmt.setString(2, restaurant.getDescription());
                stmt.setString(3, restaurant.getParkName());
                stmt.setString(4, restaurant.getArea());
                stmt.setString(5, restaurant.getOperationStatus());
                stmt.setString(6, restaurant.getOpeningTime());
                stmt.setString(7, restaurant.getClosingTime());
                stmt.setBoolean(8, restaurant.isServesVegetarian());
                stmt.setBoolean(9, restaurant.isServesVegan());
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
     * Populates the attraction table with test data.
     */
    public void populateAttractionTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Attraction/SetupAttractionData.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Populates the restaurant table with test data.
     */
    public void populateRestaurantTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Restaurant/SetupRestaurantData.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Drops the attraction table.
     */
    public void dropAttractionTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Attraction/DropAttractionTable.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Drops the restaurant table.
     */
    public void dropRestaurantTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Restaurant/DropRestaurantTable.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Creates the attraction table.
     */
    public void createAttractionTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/Attraction/CreateAttractionTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Creates the restaurant table.
     */
    public void createRestaurantTable() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/Restaurant/CreateRestaurantTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Creates the database.
     */
    public void createDatabase() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Database/CreateDatabase.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Drops the database.
     */
    public void dropDatabase() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Database/DropDatabase.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Checks to see if the database already exists.
     * @return true if the database exists, false if it does not.
     */
    public boolean databaseExists() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        boolean databaseExists = false;
        try {
            databaseExists = conn.databaseExists();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        return databaseExists;
    }
}
