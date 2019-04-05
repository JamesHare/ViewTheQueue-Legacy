package com.jamesmhare.viewthequeue.utils.themepark;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import com.jamesmhare.viewthequeue.model.show.Show;
import com.jamesmhare.viewthequeue.model.themepark.ThemePark;
import com.jamesmhare.viewthequeue.utils.TestUtilities;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a utilities class to help with the saving of the parks table state at time of testing.
 */
public class ThemeParkTestUtilities extends TestUtilities {

    private List<ThemePark> existingThemeParks;
    private List<Attraction> existingAttractions;
    private List<Restaurant> existingRestaurants;
    private List<Show> existingShows;

    public ThemeParkTestUtilities() {}

    /**
     * Saves a copy of the theme parks, attractions, restaurants and shows that currently exist in the database.
     */
    public void saveExistingParkData() {
        existingThemeParks = new ArrayList<>();
        existingAttractions = new ArrayList<>();
        existingRestaurants = new ArrayList<>();
        existingShows = new ArrayList<>();
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/ThemePark/SelectAllParks.sql");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ThemePark.Builder showBuilder = new ThemePark.Builder()
                        .withName(rs.getString("park_name"))
                        .withDescription(rs.getString("description"))
                        .withOperationStatus(rs.getString("operation_status"))
                        .withOpeningTime(rs.getString("opening_time"))
                        .withClosingTime(rs.getString("closing_time"));
                existingThemeParks.add(showBuilder.build());
            }
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        }
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
        }
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
        }
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
     * Restores the existing theme parks, attractions, restaurants and shows to the database.
     */
    public void restoreExistingParkData() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            for (ThemePark park : existingThemeParks) {
                PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/ThemePark/InsertParks.sql");
                stmt.setString(1, park.getParkName());
                stmt.setString(2, park.getDescription());
                stmt.setString(3, park.getOperationStatus());
                stmt.setString(4, park.getOpeningTime());
                stmt.setString(5, park.getClosingTime());
                stmt.execute();
                stmt.close();
            }
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        }
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
        }
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
        }
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
     * Populates the parks, attractions, restaurants and shows tables with test data.
     */
    public void populateParkDataTables() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/ThemePark/SetupParksData.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Attraction/SetupAttractionData.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Restaurant/SetupRestaurantData.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
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
     * Drops the parks, attractions, restaurants and shows tables.
     */
    public void dropParksDataTables() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/ThemePark/DropParksTable.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        }
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Attraction/DropAttractionTable.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        }
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Restaurant/DropRestaurantTable.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        }
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
     * Creates the parks, attractions, restaurants and shows tables.
     */
    public void createParksTables() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/ThemePark/CreateParksTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/Attraction/CreateAttractionTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/Restaurant/CreateRestaurantTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            conn.runDatabaseScript("src/test/resources/SQLScripts/Utils/Show/CreateShowTable.sql");
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

}
