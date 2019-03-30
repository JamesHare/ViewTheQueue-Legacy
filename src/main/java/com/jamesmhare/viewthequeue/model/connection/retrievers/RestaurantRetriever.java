package com.jamesmhare.viewthequeue.model.connection.retrievers;

import com.jamesmhare.viewthequeue.model.connection.qualifiers.RestaurantQualifier;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;

import java.util.List;

/**
 * Serves as an interface for the restaurant retriever.
 */
public interface RestaurantRetriever {

    /**
     * Searches for an restaurant given a {@code RestaurantQualifier} object.
     * @param restaurantQualifier a RestaurantQualifier object.
     * @return a List of matching restaurants.
     */
    List<Restaurant> searchRestaurants(RestaurantQualifier restaurantQualifier);

}
