package com.jamesmhare.viewthequeue.model.restaurant;

/**
 * Serves as a class for a Restaurant POJO.
 */
public class Restaurant {

    private String restaurantName, description, parkName, area, operationStatus, openingTime, closingTime;
    private boolean servesVegetarian, servesVegan;

    public Restaurant() {}

    /**
     * Sets the name of the restaurant.
     * @param restaurantName the name of the restaurant.
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * Sets the description of the restaurant.
     * @param description the description of the restaurant.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the name of the Theme Park that the restaurant belongs to.
     * @param parkName the name of the Theme Park that the restaurant belongs to.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * Sets the name of the area that the restaurant belongs to.
     * @param area the name of the area that the restaurant belongs to.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Sets the operation status of the restaurant.
     * @param operationStatus the operation status of the restaurant.
     */
    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    /**
     * Sets the opening time of the restaurant.
     * @param openingTime the opening time of the restaurant.
     */
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * Sets the closing time of the restaurant.
     * @param closingTime the closing time of the restaurant.
     */
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * Sets the vegetarian menu status of the restaurant.
     * @param servesVegetarian true if the restaurant serves vegetarian food, false if not.
     */
    public void setServesVegetarian(boolean servesVegetarian) {
        this.servesVegetarian = servesVegetarian;
    }

    /**
     * Sets the vegan menu status of the restaurant.
     * @param servesVegan true if the restaurant serves vegan food, false if not.
     */
    public void setServesVegan(boolean servesVegan) {
        this.servesVegan = servesVegan;
    }

    /**
     * Returns the name of the Restaurant.
     * @return String - the name of the Restaurant.
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Returns the description of the Restaurant.
     * @return String - the description of the Restaurant.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the Theme Park that the Restaurant belongs to.
     * @return String - the name of the Theme Park that the Restaurant belongs to.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Returns the area of the Restaurant.
     * @return String - the area of the Restaurant.
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns the operation status of the Restaurant.
     * @return String - the operation status of the Restaurant.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the opening time of the Restaurant.
     * @return String - the opening time of the Restaurant.
     */
    public String getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the Restaurant.
     * @return String - the closing time of the Restaurant.
     */
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the vegetarian status of the Restaurant.
     * @return boolean - true if the Restaurant has vegatarian menu items.
     */
    public boolean isVegetarian() {
        return servesVegetarian;
    }

    /**
     * Returns the vegan status of the Restaurant.
     * @return boolean - true if the Restaurant has vegan menu items.
     */
    public boolean isVegan() {
        return servesVegan;
    }
}
