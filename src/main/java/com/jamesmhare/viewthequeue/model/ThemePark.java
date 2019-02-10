package com.jamesmhare.viewthequeue.model;

import java.util.List;

/**
 * Serves as an abstract class for a Theme Park object.
 */
abstract class ThemePark {

    private String name;
    private String description;
    private String operationStatus;
    private String openingTime;
    private String closingTime;
    private List<Attraction> attractions;
    private List<Show> shows;
    private List<Restaurant> restaurants;

    private final void update() {
        updateDescription();
        updateOperationStatus();
        updateOpeningTime();
        updateClosingTime();
        updateAttractions();
        updateShows();
        updateRestaurants();
    }

    abstract void updateDescription();

    abstract void updateOperationStatus();

    abstract void updateOpeningTime();

    abstract void updateClosingTime();

    abstract void updateAttractions();

    abstract void updateShows();

    abstract void updateRestaurants();

    /**
     * Returns the name of the Theme Park.
     * @return String - the name of the Theme Park.
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns the description of the Theme Park.
     * @return String - the description of the Theme Park.
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Returns the operation status of the Theme Park.
     * @return String - the operation status of the Theme Park.
     */
    public final String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the opening time of the Theme Park.
     * @return String - the opening time of the Theme Park.
     */
    public final String getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the Theme Park.
     * @return String - the closing time of the Theme Park.
     */
    public final String getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the attraction information of the Theme Park.
     * @return String - the attraction information of the Theme Park.
     */
    public final List<Attraction> getAttractions() {
        return attractions;
    }
}
