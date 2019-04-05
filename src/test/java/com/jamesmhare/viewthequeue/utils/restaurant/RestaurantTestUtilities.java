package com.jamesmhare.viewthequeue.utils.restaurant;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import com.jamesmhare.viewthequeue.utils.TestUtilities;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a utilities class to help with the saving of the restaurants table state at time of testing.
 */
public class RestaurantTestUtilities extends TestUtilities {

    private List<Restaurant> existingRestaurants;

    public RestaurantTestUtilities() {}

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

}
