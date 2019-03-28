package com.jamesmhare.viewthequeue.model.connection.qualifiers;

/**
 * Serves as a way to hold search qualifiers for the Restaurant object.
 * The controller will build a qualifier with the attributes given at the end point and pass it into the {@code RestaurantRetriever}
 * for searching the database.
 */
public class RestaurantQualifier {

    private String restaurantName, parkName, area, operationStatus;
    private Boolean servesVegetarian, servesVegan;

    private RestaurantQualifier(Builder builder) {
        this.restaurantName = builder.restaurantName;
        this.parkName = builder.parkName;
        this.area = builder.area;
        this.operationStatus = builder.operationStatus;
        this.servesVegetarian = builder.servesVegetarian;
        this.servesVegan = builder.servesVegan;
    }

    /**
     * Serves as a static builder class to build a RestaurantQualifier.
     */
    public static class Builder {

        private String restaurantName, parkName, area, operationStatus;
        private Boolean servesVegetarian, servesVegan;

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
         * Sets the vegetarian status of the restaurant menu.
         * @param servesVegetarian true if the restaurant has vegetarian options, false if not.
         * @return the Builder object.
         */
        public Builder servesVegetarian(Boolean servesVegetarian) {
            this.servesVegetarian = servesVegetarian;
            return this;
        }

        /**
         * Sets the vegan status of the restaurant menu.
         * @param servesVegan true if the restaurant has vegan options, false if not.
         * @return the Builder object.
         */
        public Builder servesVegan(Boolean servesVegan) {
            this.servesVegan = servesVegan;
            return this;
        }

        /**
         * Builds the RestaurantQualifier object using the builder.
         * @return the RestaurantQualifier object.
         */
        public RestaurantQualifier build() {
            return new RestaurantQualifier(this);
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
     * Returns the vegetarian status of the Restaurant.
     * @return true if the Restaurant has vegetarian menu items, false if not.
     */
    public Boolean servesVegetarian() {
        return servesVegetarian;
    }

    /**
     * Returns the vegan status of the Restaurant.
     * @return true if the Restaurant has vegan menu items, false if not.
     */
    public Boolean servesVegan() {
        return servesVegan;
    }

}
