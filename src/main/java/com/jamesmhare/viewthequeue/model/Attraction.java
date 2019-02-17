package com.jamesmhare.viewthequeue.model;

/**
 * Serves as a class for an Attraction object.
 */
public class Attraction {

    public String attractionName;
    public String description;
    public String parkName;
    public String area;
    public String operationStatus;
    public String openingTime;
    public String closingTime;
    public String waitTime;
    public int maxHeightRestrictionInches;
    public int minHeightRestrictionInches;
    public boolean isWheelchairAccessible;
    public boolean hasExpressLine;
    public boolean hasSingleRider;

    public Attraction(String attractionName) {
        this.attractionName = attractionName;
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

    private void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    private void setMaxHeightRestrictionInches(int maxHeightRestrictionInches) {
        this.maxHeightRestrictionInches = maxHeightRestrictionInches;
    }

    private void setMinHeightRestrictionInches(int minHeightRestrictionInches) {
        this.minHeightRestrictionInches = minHeightRestrictionInches;
    }

    private void setWheelchairAccessible(boolean wheelchairAccessible) {
        isWheelchairAccessible = wheelchairAccessible;
    }

    private void setHasExpressLine(boolean hasExpressLine) {
        this.hasExpressLine = hasExpressLine;
    }

    private void setHasSingleRider(boolean hasSingleRider) {
        this.hasSingleRider = hasSingleRider;
    }

    /**
     * Returns the name of the Attraction.
     * @return String - the name of the Attraction.
     */
    public String getAttractionName() {
        return attractionName;
    }

    /**
     * Returns the description of the Attraction.
     * @return String - the description of the Attraction.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the Theme Park that the Attraction belongs to.
     * @return String - the name of the Theme Park that the Attraction belongs to.
     */
    public String getParkName() {
        return parkName;
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
