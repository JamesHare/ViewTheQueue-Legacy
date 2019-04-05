package com.jamesmhare.viewthequeue.model.connection.retrievers.mysql;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import com.jamesmhare.viewthequeue.model.connection.qualifiers.ThemeParkQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.ThemeParkRetriever;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import com.jamesmhare.viewthequeue.model.show.Show;
import com.jamesmhare.viewthequeue.model.themepark.ThemePark;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLThemeParkRetriever implements ThemeParkRetriever {

    public MySQLThemeParkRetriever() {}

    /**
     * {@inheritDoc}
     */
    public List<ThemePark> searchThemeParks(ThemeParkQualifier themeParkQualifier) {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        List<ThemePark> parks = new ArrayList<>();
        String query = buildParksStatement(themeParkQualifier);
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                processParkRow(rs, parks);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        return parks;
    }

    private String buildParksStatement(ThemeParkQualifier themeParkQualifier) {
        StringBuilder query = new StringBuilder("SELECT * FROM ViewTheQueueDB.parks");
        if (themeParkQualifier.getParkName() == null) {
            query.append(" WHERE park_name LIKE '%'");
        } else {
            query.append(" WHERE park_name = '" + themeParkQualifier.getParkName() + "'");
        }
        if (themeParkQualifier.getOperationStatus() != null) {
            query.append(" AND operation_status = '" + themeParkQualifier.getOperationStatus() + "'");
        }
        return query.toString();
    }

    private void processParkRow(ResultSet rs, List<ThemePark> parks) {
        try {
            ThemePark.Builder parkBuilder = new ThemePark.Builder()
                    .withName(rs.getString("park_name"))
                    .withDescription(rs.getString("description"))
                    .withOperationStatus(rs.getString("operation_status"))
                    .withOpeningTime(rs.getString("opening_time"))
                    .withClosingTime(rs.getString("closing_time"))
                    .withAttractions(getAttractionsInPark(rs))
                    .withRestaurants(getRestaurantsInPark(rs))
                    .withShows(getShowsInPark(rs));
            parks.add(parkBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private List<Attraction> getAttractionsInPark(ResultSet rs) {
        MySQLConnectionProxy attractionsConn = new MySQLConnectionProxy();
        List<Attraction> attractionsInPark = new ArrayList<>();
        String query = buildParkAmenitiesStatement(rs, "attractions");
        try {
            PreparedStatement stmt = attractionsConn.getConnection().prepareStatement(query);
            ResultSet attractionsRS = stmt.executeQuery();
            while (attractionsRS.next()) {
                processAttractionRow(attractionsRS, attractionsInPark);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            attractionsConn.closeConnection();
        }
        return attractionsInPark;
    }

    private void processAttractionRow(ResultSet attractionsRS, List<Attraction> attractionsInPark) {
        try {
            Attraction.Builder attractionBuilder = new Attraction.Builder()
                    .withName(attractionsRS.getString("attraction_name"))
                    .withDescription(attractionsRS.getString("description"))
                    .withParkName(attractionsRS.getString("park_name"))
                    .withArea(attractionsRS.getString("area"))
                    .withOperationStatus(attractionsRS.getString("operation_status"))
                    .withOpeningTime(attractionsRS.getString("opening_time"))
                    .withClosingTime(attractionsRS.getString("closing_time"))
                    .withWaitTime(attractionsRS.getInt("wait_time"))
                    .withMaxHeightRestrictionInInches(attractionsRS.getInt("max_height_restriction_inches"))
                    .withMinHeightRestrictionInInches(attractionsRS.getInt("min_height_restriction_inches"))
                    .withWheelchairAccessibility(attractionsRS.getBoolean("is_wheelchair_accessible"))
                    .withExpressLine(attractionsRS.getBoolean("has_express_line"))
                    .withSingleRiderLine(attractionsRS.getBoolean("has_single_rider"));
            attractionsInPark.add(attractionBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private List<Restaurant> getRestaurantsInPark(ResultSet rs) {
        MySQLConnectionProxy restaurantsConn = new MySQLConnectionProxy();
        List<Restaurant> restaurantsInPark = new ArrayList<>();
        String query = buildParkAmenitiesStatement(rs, "restaurants");
        try {
            PreparedStatement stmt = restaurantsConn.getConnection().prepareStatement(query);
            ResultSet restaurantsRS = stmt.executeQuery();
            while (restaurantsRS.next()) {
                processRestaurantRow(restaurantsRS, restaurantsInPark);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            restaurantsConn.closeConnection();
        }
        return restaurantsInPark;
    }

    private void processRestaurantRow(ResultSet restaurantsRS, List<Restaurant> restaurantsInPark) {
        try {
            Restaurant.Builder restaurantBuilder = new Restaurant.Builder()
                    .withName(restaurantsRS.getString("restaurant_name"))
                    .withDescription(restaurantsRS.getString("description"))
                    .withParkName(restaurantsRS.getString("park_name"))
                    .withArea(restaurantsRS.getString("area"))
                    .withOperationStatus(restaurantsRS.getString("operation_status"))
                    .withOpeningTime(restaurantsRS.getString("opening_time"))
                    .withClosingTime(restaurantsRS.getString("closing_time"))
                    .servesVegetarian(restaurantsRS.getBoolean("serves_vegetarian"))
                    .servesVegan(restaurantsRS.getBoolean("serves_vegan"));
            restaurantsInPark.add(restaurantBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private List<Show> getShowsInPark(ResultSet rs) {
        MySQLConnectionProxy showsConn = new MySQLConnectionProxy();
        List<Show> showsInPark = new ArrayList<>();
        String query = buildParkAmenitiesStatement(rs, "shows");
        try {
            PreparedStatement stmt = showsConn.getConnection().prepareStatement(query);
            ResultSet showsRS = stmt.executeQuery();
            while (showsRS.next()) {
                processShowRow(showsRS, showsInPark);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            showsConn.closeConnection();
        }
        return showsInPark;
    }

    private void processShowRow(ResultSet showsRS, List<Show> showsInPark) {
        try {
            Show.Builder showBuilder = new Show.Builder()
                    .withName(showsRS.getString("show_name"))
                    .withDescription(showsRS.getString("description"))
                    .withParkName(showsRS.getString("park_name"))
                    .withArea(showsRS.getString("area"))
                    .withOperationStatus(showsRS.getString("operation_status"))
                    .withShowTimes(showsRS.getString("show_times"))
                    .withExpressLine(showsRS.getBoolean("has_express_line"))
                    .withWheelchairAccessibility(showsRS.getBoolean("is_wheelchair_accessible"));
            showsInPark.add(showBuilder.build());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private String buildParkAmenitiesStatement(ResultSet rs, String amenityType) {
        StringBuilder query = new StringBuilder("SELECT * FROM ViewTheQueueDB." + amenityType);
        try {
            if (rs.getString("park_name") != null) {
                query.append(" WHERE park_name = '" + rs.getString("park_name") + "'");
            } else {
                throw new NullPointerException();
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return query.toString();
    }

}
