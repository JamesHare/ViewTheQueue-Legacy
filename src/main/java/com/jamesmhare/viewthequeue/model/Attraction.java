package com.jamesmhare.viewthequeue.model;

/**
 * Serves as an abstract class for a Attraction object.
 */
abstract class Attraction {

    private String name;
    private String description;
    private String area;
    private String operationStatus;
    private String openingTime;
    private String closingTime;
    private String waitTime;
    private int maxHeightRestrictionInches;
    private int minHeightRestrictionInches;
    private boolean isWheelchairAccessible;
    private boolean hasExpressLine;
    private boolean hasSingleRider;

    private final void update() {
        updateDescription();
        updateOperationStatus();
        updateArea();
        updateOpeningTime();
        updateClosingTime();
        updateWaitTime();
        updateMaxHeightRestrictionInches();
        updateMinHeightRestrictionInches();
        updateIsWheelchairAccessible();
        updateHasExpressLine();
        updateHasSingleRider();
    }

    abstract void updateDescription();

    abstract void updateOperationStatus();

    abstract void updateArea();

    abstract void updateOpeningTime();

    abstract void updateClosingTime();

    abstract void updateWaitTime();

    abstract void updateMaxHeightRestrictionInches();

    abstract void updateMinHeightRestrictionInches();

    abstract void updateIsWheelchairAccessible();

    abstract void updateHasExpressLine();

    abstract void updateHasSingleRider();

    /**
     * Returns the name of the Attraction.
     * @return String - the name of the Attraction.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the Attraction.
     * @return String - the description of the Attraction.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the area of the Attraction.
     * @return String - the area of the Attraction.
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns the operation status of the Attraction.
     * @return String - the operation status of the Attraction.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the opening time of the Attraction.
     * @return String - the opening time of the Attraction.
     */
    public String getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the Attraction.
     * @return String - the closing time of the Attraction.
     */
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the wait time of the Attraction.
     * @return String - the wait time of the Attraction.
     */
    public String getWaitTime() {
        return waitTime;
    }

    /**
     * Returns the maximum height restriction of the Attraction in inches.
     * @return int - the maximum height restriction of the Attraction in inches.
     */
    public int getMaxHeightRestrictionInches() {
        return maxHeightRestrictionInches;
    }

    /**
     * Returns the minimum height restriction of the Attraction in inches.
     * @return int - the minimum height restriction of the Attraction in inches.
     */
    public int getMinHeightRestrictionInches() {
        return minHeightRestrictionInches;
    }

    /**
     * Returns the wheelchair accessibility of the Attraction.
     * @return boolean - true if the Attraction is wheelchair accessible.
     */
    public boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    /**
     * Returns there is an express line for the Attraction.
     * @return boolean - true if there is an express line for the Attraction.
     */
    public boolean hasExpressLine() {
        return hasExpressLine;
    }

    /**
     * Returns there is a single rider line for the Attraction.
     * @return boolean - true if there is a single rider line for the Attraction.
     */
    public boolean hasSingleRider() {
        return hasSingleRider;
    }
}
