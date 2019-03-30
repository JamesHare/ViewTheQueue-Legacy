package com.jamesmhare.viewthequeue.model.connection.retrievers.mysql;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.connection.qualifiers.RestaurantQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.RestaurantRetriever;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;

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
    public List<Restaurant> searchRestaurants(RestaurantQualifier restaurantQualifier) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<Restaurant> restaurants = new ArrayList<>();
        String query = buildStatement(restaurantQualifier);
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processRow(rs, restaurants);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        return restaurants;
    }

    private String buildStatement(RestaurantQualifier restaurantQualifier) {
        StringBuilder query = new StringBuilder("SELECT * FROM ViewTheQueueDB.restaurants");
        if (restaurantQualifier.getRestaurantName() == null) {
            query.append(" WHERE restaurant_name LIKE '%'");
        } else {
            query.append(" WHERE restaurant_name = '" + restaurantQualifier.getRestaurantName() + "'");
        }
        if (restaurantQualifier.getParkName() == null) {
            query.append(" AND park_name LIKE '%'");
        } else {
            query.append(" AND park_name = '" + restaurantQualifier.getParkName() + "'");
        }
        if (restaurantQualifier.getArea() == null) {
            query.append(" AND area LIKE '%'");
        } else {
            query.append(" AND area = '" + restaurantQualifier.getArea() + "'");
        }
        if (restaurantQualifier.getOperationStatus() == null) {
            query.append(" AND operation_status LIKE '%'");
        } else {
            query.append(" AND operation_status = '" + restaurantQualifier.getOperationStatus() + "'");
        }
        if (restaurantQualifier.servesVegetarian() != null) {
            query.append(" AND serves_vegetarian = " + restaurantQualifier.servesVegetarian());
        }
        if (restaurantQualifier.servesVegan() != null) {
            query.append(" AND serves_vegan = " + restaurantQualifier.servesVegan());
        }
        return query.toString();
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
