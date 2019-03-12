package com.jamesmhare.viewthequeue.model.connection.retrievers;

import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;

import java.util.List;

/**
 * Serves as an interface for the restaurant retriever.
 */
public interface RestaurantRetriever {

    /**
     * Searches for a restaurants with a given name. Will return a list of only one restaurant
     * or an empty list if more than one restaurant is retrieved from the database.
     * @param restaurantName the name of the restaurant
     * @return the list of one single restaurant.
     */
    List<Restaurant> searchRestaurantByName(String restaurantName);

    /**
     * Searches for all restaurants in a given Theme Park.
     * @param parkName the name of the Theme Park.
     * @return a List containing the matching restaurants or an empty list if none are found.
     */
    List<Restaurant> searchRestaurantByThemeParkName(String parkName);

    /**
     * Searches for all restaurants in a given area.
     * @param area the name of the area.
     * @return a List containing the matching restaurants or an empty list if none are found.
     */
    List<Restaurant> searchRestaurantByArea(String area);

    /**
     * Searches for all restaurants with a given operation status.
     * @param operationStatus the operation status of the restaurants.
     * @return a List containing the matching restaurants or an empty list if none are found.
     */
    List<Restaurant> searchRestaurantByOperationStatus(String operationStatus);

    /**
     * Searches for all restaurants with vegetarian menu options.
     * @param servesVegetarian true for restaurants serving vegetarian options, false for restaurants without.
     * @return a List containing the matching restaurants or an empty list if none are found.
     */
    List<Restaurant> searchRestaurantByVegetarianAvailability(boolean servesVegetarian);

    /**
     * Searches for all restaurants with vegan menu options.
     * @param servesVegan true for restaurants serving vegan options, false for restaurants without.
     * @return a List containing the matching restaurants or an empty list if none are found.
     */
    List<Restaurant> searchRestaurantByVeganAvailability(boolean servesVegan);

    /**
     * Retrieves all the restaurants.
     * @return a List containing all the restaurants.
     */
    List<Restaurant> retrieveAllRestaurants();

}
