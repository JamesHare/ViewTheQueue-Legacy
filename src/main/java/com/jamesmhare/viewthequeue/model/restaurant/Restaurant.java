package com.jamesmhare.viewthequeue.model.restaurant;

/**
 * Serves as a class for a Restaurant POJO.
 */
public class Restaurant {

    private String restaurantName, description, parkName, area, operationStatus, openingTime, closingTime;
    private boolean servesVegetarian, servesVegan;

    private Restaurant(Builder builder) {
        this.restaurantName = builder.restaurantName;
        this.description = builder.description;
        this.parkName = builder.parkName;
        this.area = builder.area;
        this.operationStatus = builder.operationStatus;
        this.openingTime = builder.openingTime;
        this.closingTime = builder.closingTime;
        this.servesVegetarian = builder.servesVegetarian;
        this.servesVegan = builder.servesVegan;
    }

    /**
     * Serves as a static builder class to build a Restaurant POJO.
     */
    public static class Builder {

        private String restaurantName, description, parkName, area, operationStatus, openingTime, closingTime;
        private boolean servesVegetarian, servesVegan;

        public Builder() {}

        /**
         * Sets the name of the restaurant.
         * @param restaurantName the name of the restaurant.
         * @return the Builder object.
         */
        public Builder withName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        /**
         * Sets the description of the restaurant.
         * @param description the description of the restaurant.
         * @return the Builder object.
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the name of the Theme Park that the restaurant belongs to.
         * @param parkName the name of the Theme Park that the restaurant belongs to.
         * @return the Builder object.
         */
        public Builder withParkName(String parkName) {
            this.parkName = parkName;
            return this;
        }

        /**
         * Sets the name of the area that the restaurant belongs to.
         * @param area the name of the area that the restaurant belongs to.
         * @return the Builder object.
         */
        public Builder withArea(String area) {
            this.area = area;
            return this;
        }

        /**
         * Sets the operation status of the restaurant.
         * @param operationStatus the operation status of the restaurant.
         * @return the Builder object.
         */
        public Builder withOperationStatus(String operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        /**
         * Sets the opening time of the restaurant.
         * @param openingTime the opening time of the restaurant.
         * @return the Builder object.
         */
        public Builder withOpeningTime(String openingTime) {
            this.openingTime = openingTime;
            return this;
        }

        /**
         * Sets the closing time of the restaurant.
         * @param closingTime the closing time of the restaurant.
         * @return the Builder object.
         */
        public Builder withClosingTime(String closingTime) {
            this.closingTime = closingTime;
            return this;
        }

        /**
         * Sets the vegetarian status of the restaurant menu.
         * @param servesVegetarian true if the restaurant has vegetarian options, false if not.
         * @return the Builder object.
         */
        public Builder servesVegetarian(boolean servesVegetarian) {
            this.servesVegetarian = servesVegetarian;
            return this;
        }

        /**
         * Sets the vegan status of the restaurant menu.
         * @param servesVegan true if the restaurant has vegan options, false if not.
         * @return the Builder object.
         */
        public Builder servesVegan(boolean servesVegan) {
            this.servesVegan = servesVegan;
            return this;
        }

        /**
         * Builds the Restaurant object using the builder.
         * @return the Restaurant object.
         */
        public Restaurant build() {
            return new Restaurant(this);
        }
    }

    /**
     * Returns the name of the Restaurant.
     * @return the name of the Restaurant.
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Returns the description of the Restaurant.
     * @return the description of the Restaurant.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the Theme Park that the Restaurant belongs to.
     * @return the name of the Theme Park that the Restaurant belongs to.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Returns the area of the Restaurant.
     * @return the area of the Restaurant.
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns the operation status of the Restaurant.
     * @return the operation status of the Restaurant.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the opening time of the Restaurant.
     * @return the opening time of the Restaurant.
     */
    public String getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the Restaurant.
     * @return the closing time of the Restaurant.
     */
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the vegetarian status of the Restaurant.
     * @return true if the Restaurant has vegetarian menu items, false if not.
     */
    public boolean isServesVegetarian() {
        return servesVegetarian;
    }

    /**
     * Returns the vegan status of the Restaurant.
     * @return true if the Restaurant has vegan menu items, false if not.
     */
    public boolean isServesVegan() {
        return servesVegan;
    }
}
