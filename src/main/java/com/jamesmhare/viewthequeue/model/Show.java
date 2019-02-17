package com.jamesmhare.viewthequeue.model;

import java.util.List;

/**
 * Serves as a class for a Show object.
 */
public class Show {

    public String showName;
    public String description;
    public String parkName;
    public String area;
    public String operationStatus;
    public boolean isWheelchairAccessible;
    public boolean hasExpressLine;
    public List<String> showTimes;

    public Show(String showName) {
        this.showName = showName;
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

    private void setWheelchairAccessible(boolean wheelchairAccessible) {
        isWheelchairAccessible = wheelchairAccessible;
    }

    private void setHasExpressLine(boolean hasExpressLine) {
        this.hasExpressLine = hasExpressLine;
    }

    private void setShowTimes(List<String> showTimes) {
        this.showTimes = showTimes;
    }

    /**
     * Returns the name of the Show.
     * @return String - the name of the Show.
     */
    public String getShowName() {
        return showName;
    }

    /**
     * Returns the description of the Show.
     * @return String - the description of the Show.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the park name that the Show belongs to.
     * @return String - the park name that the Show belongs to.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Returns the area of the Show.
     * @return String - the area of the Show.
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns the operation status of the Show.
     * @return String - the operation status of the Show.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the wheelchair accessibility of the Show.
     * @return boolean - true is the Show is wheelchair accessible.
     */
    public boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    /**
     * Returns there is an express line for the Show.
     * @return boolean - true if there is an express line for the Show.
     */
    public boolean hasExpressLine() {
        return hasExpressLine;
    }

    /**
     * Returns the show times of the Show.
     * @return List of Strings - the show times of the Show.
     */
    public List<String> getShowTimes() {
        return showTimes;
    }
}
