package com.jamesmhare.viewthequeue.model;

import java.util.List;

/**
 * Serves as a class for a Theme Park object.
 */
public class ThemePark {

    public String parkName;
    public String description;
    public String operationStatus;
    public String openingTime;
    public String closingTime;
    public List<Attraction> attractions;
    public List<Show> shows;
    public List<Restaurant> restaurants;

    public ThemePark(String parkName) {
        this.parkName = parkName;
        retrieveAttributes();
    }

    private void retrieveAttributes() {

    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    private void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    private void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    private void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    private void setShows(List<Show> shows) {
        this.shows = shows;
    }

    private void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    /**
     * Returns the name of the Theme Park.
     * @return String - the name of the Theme Park.
     */
    public final String getParkName() {
        return parkName;
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

    /**
     * Returns the show information of the Theme Park.
     * @return String - the show information of the Theme Park.
     */
    public List<Show> getShows() {
        return shows;
    }

    /**
     * Returns the restaurant information of the Theme Park.
     * @return String - the restaurant information of the Theme Park.
     */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
