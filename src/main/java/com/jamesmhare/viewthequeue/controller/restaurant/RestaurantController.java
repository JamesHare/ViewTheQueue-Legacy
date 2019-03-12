package com.jamesmhare.viewthequeue.controller.restaurant;

import com.jamesmhare.viewthequeue.model.connection.retrievers.mysql.MySQLRestaurantRetriever;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves as a controller for {@link Restaurant} based calls to the API.
 */
@RestController
public class RestaurantController {

    MySQLRestaurantRetriever restaurantRetriever = new MySQLRestaurantRetriever();

    /**
     * Makes a request to the API for a {@link Restaurant} given a Restaurant name.
     * @param name the name of the Restaurant.
     * @return the matching Restaurant.
     */
    @GetMapping(value = "/restaurant-with-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> restaurantByName(@RequestParam(value="name", defaultValue="null") String name) {
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurantByName(name);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for a {@link Restaurant} given a Theme Park.
     * @param themeParkName the Theme Park in which the Restaurant is located.
     * @return all matching Restaurants.
     */
    @GetMapping(value = "/restaurants-in-park", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> restaurantsByThemePark(@RequestParam(value="park-name", defaultValue="null") String themeParkName) {
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurantByThemeParkName(themeParkName);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for a {@link Restaurant} given an area.
     * @param area the area in which the Restaurant is located.
     * @return all matching Restaurants.
     */
    @GetMapping(value = "/restaurants-in-area", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> restaurantsByArea(@RequestParam(value="area", defaultValue="null") String area) {
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurantByArea(area);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for a {@link Restaurant} given an operation status.
     * @param operationStatus the operation status of the Restaurant
     * @return all matching Restaurants.
     */
    @GetMapping(value = "/restaurants-with-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> restaurantsByOperationStatus(@RequestParam(value="status", defaultValue="null") String operationStatus) {
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurantByOperationStatus(operationStatus);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for a {@link Restaurant} given the vegetarian menu availability.
     * @param servesVegetarian the vegetarian menu availability of the Restaurant. True if available, false if not.
     * @return all matching Restaurants.
     */
    @GetMapping(value = "/restaurants-with-vegetarian-options", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> restaurantsByVegetarianAvailability(@RequestParam(value="serves-vegetarian", defaultValue="null") boolean servesVegetarian) {
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurantByVegetarianAvailability(servesVegetarian);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for a {@link Restaurant} given the vegan menu availability.
     * @param servesVegan the vegan menu availability of the Restaurant. True if available, false if not.
     * @return all matching Restaurants.
     */
    @GetMapping(value = "/restaurants-with-vegan-options", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> restaurantsByVeganAvailability(@RequestParam(value="serves-vegan", defaultValue="null") boolean servesVegan) {
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurantByVeganAvailability(servesVegan);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for all {@link Restaurant} objects in the database.
     * @return all Restaurants.
     */
    @GetMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> allRestaurants() {
        List<Restaurant> restaurants = restaurantRetriever.retrieveAllRestaurants();
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

}
