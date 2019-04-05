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

    private ThemePark(Builder builder) {
        this.parkName = builder.parkName;
        this.description = builder.description;
        this.operationStatus = builder.operationStatus;
        this.openingTime = builder.openingTime;
        this.closingTime = builder.closingTime;
        this.attractions = builder.attractions;
        this.shows = builder.shows;
        this.restaurants = builder.restaurants;
    }

    /**
     * Serves as a static builder class to build a Theme Park POJO.
     */
    public static class Builder {

        private String parkName, description, operationStatus, openingTime, closingTime;
        private List<Attraction> attractions;
        private List<Show> shows;
        private List<Restaurant> restaurants;

        public Builder() {}

        /**
         * Sets the name of the park.
         * @param parkName the name of the park.
         * @return the Builder object.
         */
        public Builder withName(String parkName) {
            this.parkName = parkName;
            return this;
        }

        /**
         * Sets the description of the park.
         * @param description the description of the park.
         * @return the Builder object.
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the operation status of the park.
         * @param operationStatus the operation status of the park.
         * @return the Builder object.
         */
        public Builder withOperationStatus(String operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        /**
         * Sets the opening time of the park.
         * @param openingTime the opening time of the park.
         * @return the Builder object.
         */
        public Builder withOpeningTime(String openingTime) {
            this.openingTime = openingTime;
            return this;
        }

        /**
         * Sets the closing time of the park.
         * @param closingTime the closing time of the park.
         * @return the Builder object.
         */
        public Builder withClosingTime(String closingTime) {
            this.closingTime = closingTime;
            return this;
        }

        /**
         * Sets the attraction POJOs belonging to the park.
         * @param attractions the attraction POJOs belonging to the park.
         * @return the Builder object.
         */
        public Builder withAttractions(List<Attraction> attractions){
            this.attractions = attractions;
            return this;
        }

        /**
         * Sets the show POJOs belonging to the park.
         * @param shows the show POJOs belonging to the park.
         * @return the Builder object.
         */
        public Builder withShows(List<Show> shows){
            this.shows = shows;
            return this;
        }

        /**
         * Sets the restaurant POJOs belonging to the park.
         * @param restaurants the restaurant POJOs belonging to the park.
         * @return the Builder object.
         */
        public Builder withRestaurants(List<Restaurant> restaurants){
            this.restaurants = restaurants;
            return this;
        }

        /**
         * Builds the ThemePark object using the builder.
         * @return the ThemePark object.
         */
        public ThemePark build() {
            return new ThemePark(this);
        }

    }

    /**
     * Returns the name of the Theme Park.
     * @return the name of the Theme Park.
     */
    public final String getParkName() {
        return parkName;
    }

    /**
     * Returns the description of the Theme Park.
     * @return the description of the Theme Park.
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Returns the operation status of the Theme Park.
     * @return the operation status of the Theme Park.
     */
    public final String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the opening time of the Theme Park.
     * @return the opening time of the Theme Park.
     */
    public final String getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the Theme Park.
     * @return the closing time of the Theme Park.
     */
    public final String getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the attraction information of the Theme Park.
     * @return the attraction information of the Theme Park.
     */
    public final List<Attraction> getAttractions() {
        return attractions;
    }

    /**
     * Returns the show information of the Theme Park.
     * @return the show information of the Theme Park.
     */
    public List<Show> getShows() {
        return shows;
    }

    /**
     * Returns the restaurant information of the Theme Park.
     * @return the restaurant information of the Theme Park.
     */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
