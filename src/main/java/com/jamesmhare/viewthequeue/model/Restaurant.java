package com.jamesmhare.viewthequeue.model;

/**
 * Serves as an abstract class for a Restaurant object.
 */
abstract class Restaurant {

    private String name;
    private String description;
    private String area;
    private String operationStatus;
    private String openingTime;
    private String closingTime;
    private boolean servesVegetarian;
    private boolean servesVegan;

    private final void update() {
        updateDescription();
        updateArea();
        updateOperationStatus();
        updateOpeningTime();
        updateClosingTime();
        updateServesVegetarian();
        updateServesVegan();
    }

    abstract void updateDescription();

    abstract void updateArea();

    abstract void updateOperationStatus();

    abstract void updateOpeningTime();

    abstract void updateClosingTime();

    abstract void updateServesVegetarian();

    abstract void updateServesVegan();

    /**
     * Returns the name of the Restaurant.
     * @return String - the name of the Restaurant.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the Restaurant.
     * @return String - the description of the Restaurant.
     */
    public String getDescription() {
        return description;
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
