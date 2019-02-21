package com.jamesmhare.viewthequeue.model.themepark;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import com.jamesmhare.viewthequeue.model.show.Show;

import java.util.List;

/**
 * Serves as a class for a Theme Park POJO.
 */
public class ThemePark {

    private String parkName, description, operationStatus, openingTime, closingTime;
    private List<Attraction> attractions;
    private List<Show> shows;
    private List<Restaurant> restaurants;

    public ThemePark() {}

    /**
     * Sets the name of the Theme Park.
     * @param parkName the name of the Theme Park.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * Sets the description of the Theme Park.
     * @param description the description of the Theme Park.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the operation status of the Theme Park.
     * @param operationStatus the operation status of the Theme Park.
     */
    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    /**
     * Sets the opening time of the Theme Park.
     * @param openingTime the opening time of the Theme Park.
     */
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * Sets the closing time of the Theme Park.
     * @param closingTime the closing time of the Theme Park.
     */
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * Sets the attractions of the Theme Park.
     * @param attractions the attractions of the Theme Park.
     */
    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    /**
     * Sets the shows of the Theme Park.
     * @param shows the shows of the Theme Park.
     */
    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    /**
     * Sets the restaurants of the Theme Park.
     * @param restaurants the restaurants of the Theme Park.
     */
    public void setRestaurants(List<Restaurant> restaurants) {
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
