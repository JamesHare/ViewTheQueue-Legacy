package com.jamesmhare.viewthequeue.model.connection.retrievers.mysql;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.connection.retrievers.RestaurantRetriever;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a class to retrieve {@link Restaurant} objects from a MySQL database.
 */
public class MySQLRestaurantRetriever implements RestaurantRetriever {

    public MySQLRestaurantRetriever() {}

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> searchRestaurantByName(String restaurantName) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql", "WHERE restaurant_name = ?");
            stmt.setString(1, restaurantName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the restaurant name: " + restaurantName);
        } else if (restaurants.size() > 1) {
            restaurants.clear();
            System.out.println("More than one entry was retrieved from the database given the restaurant name: " + restaurantName);
        }
        return restaurants;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> searchRestaurantByThemeParkName(String parkName) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql", "WHERE park_name = ?");
            stmt.setString(1, parkName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the Theme Park name: " + parkName);
        }
        return restaurants;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> searchRestaurantByArea(String area) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql", "WHERE area = ?");
            stmt.setString(1, area);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the area name: " + area);
        }
        return restaurants;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> searchRestaurantByOperationStatus(String operationStatus) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql", "WHERE operation_status = ?");
            stmt.setString(1, operationStatus);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the operation status: " + operationStatus);
        }
        return restaurants;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> searchRestaurantByVegetarianAvailability(boolean servesVegetarian) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql", "WHERE serves_vegetarian = ?");
            stmt.setBoolean(1, servesVegetarian);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the vegetarian option: " + servesVegetarian);
        }
        return restaurants;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> searchRestaurantByVeganAvailability(boolean servesVegan) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql", "WHERE serves_vegetarian = ?");
            stmt.setBoolean(1, servesVegan);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("Could not retrieve an entry from the database given the vegan option: " + servesVegan);
        }
        return restaurants;
    }

    /**
     * {@inheritDoc}
     */
    public List<Restaurant> retrieveAllRestaurants() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/main/resources/SQLScripts/retrievers/RetrieveRestaurant.sql");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        if (restaurants.size() == 0) {
            System.out.println("No restaurants found.");
        }
        return restaurants;
    }

    private void processRow(ResultSet rs, List<Restaurant> restaurants) {
        try {
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
            restaurants.add(restaurantBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
