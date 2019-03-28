package com.jamesmhare.viewthequeue.controller.restaurant;

import com.jamesmhare.viewthequeue.model.connection.qualifiers.RestaurantQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.mysql.MySQLRestaurantRetriever;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves as a controller for {@link Restaurant} based calls to the API.
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    MySQLRestaurantRetriever restaurantRetriever = new MySQLRestaurantRetriever();

    /**
     *
     * @param restaurantName the name of a restaurant.
     * @param parkName the name of the park in which the restaurant is located.
     * @param area the name of the area in which the restaurant is located.
     * @param operationStatus the operation status of the restaurant. Can be Open or Closed.
     * @param servesVegetarian the vegetarian status of the restaurant. Can be true or false.
     * @param servesVegan the vegan status of the restaurant. Can be true or false.
     * @return all matching restaurants as a JSON.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getMatchingRestaurants(
            @RequestParam(value="name", required=false) String restaurantName,
            @RequestParam(value="parkname", required=false) String parkName,
            @RequestParam(value="area", required=false) String area,
            @RequestParam(value="operationstatus", required=false) String operationStatus,
            @RequestParam(value="servesvegetarian", required=false) Boolean servesVegetarian,
            @RequestParam(value="servesvegan", required=false) Boolean servesVegan) {
        RestaurantQualifier restaurantQualifier = new RestaurantQualifier.Builder()
                .withName(restaurantName)
                .withParkName(parkName)
                .withArea(area)
                .withOperationStatus(operationStatus)
                .servesVegetarian(servesVegetarian)
                .servesVegan(servesVegan)
                .build();
        List<Restaurant> restaurants = restaurantRetriever.searchRestaurants(restaurantQualifier);
        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(restaurants, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }

    }
}
