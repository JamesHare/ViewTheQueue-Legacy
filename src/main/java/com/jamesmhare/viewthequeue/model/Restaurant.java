package com.jamesmhare.viewthequeue.model;

/**
 * Serves as a class for a Restaurant object.
 */
public class Restaurant {

    public String restaurantName;
    public String description;
    public String parkName;
    public String area;
    public String operationStatus;
    public String openingTime;
    public String closingTime;
    public boolean servesVegetarian;
    public boolean servesVegan;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        retrieveAttributes();
    }

    private void retrieveAttributes() {

    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setParkName(String parkName) {
        this.parkName = parkName;
    }

    private void setArea(String area) {
        this.area = area;
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

    private void setServesVegetarian(boolean servesVegetarian) {
        this.servesVegetarian = servesVegetarian;
    }

    private void setServesVegan(boolean servesVegan) {
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
    public boolean servesVegetarian() {
        return servesVegetarian;
    }

    /**
     * Returns the vegan status of the Restaurant.
     * @return boolean - true if the Restaurant has vegan menu items.
     */
    public boolean servesVegan() {
        return servesVegan;
    }
}
