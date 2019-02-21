package com.jamesmhare.viewthequeue.model.show;

/**
 * Serves as a class for a Show POJO.
 */
public class Show {

    private String showName, description, parkName, area, operationStatus, showTimes;
    private boolean isWheelchairAccessible, hasExpressLine;

    public Show() {}

    /**
     * Sets the name of the show.
     * @param showName the name of the show.
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * Sets the description of the show.
     * @param description the description of the show.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the name of the Theme Park that the show belongs to.
     * @param parkName the name of the Theme Park that the show belongs to.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * Sets the name of the area that the show belongs to.
     * @param area the name of the area that the show belongs to.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Sets the operation status of the show.
     * @param operationStatus the operation status of the show.
     */
    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    /**
     * Sets the wheelchair accessibility of the show.
     * @param wheelchairAccessible true if the show has wheelchair accessibility, false if not.
     */
    public void setWheelchairAccessible(boolean wheelchairAccessible) {
        isWheelchairAccessible = wheelchairAccessible;
    }

    /**
     * Sets if there is an express line for the show or not.
     * @param hasExpressLine true if there is an express line, false if there is not.
     */
    public void setHasExpressLine(boolean hasExpressLine) {
        this.hasExpressLine = hasExpressLine;
    }

    /**
     * Sets the show times of the show.
     * @param showTimes the show times of the show.
     */
    public void setShowTimes(String showTimes) {
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
    public boolean isExpressLine() {
        return hasExpressLine;
    }

    /**
     * Returns the show times of the Show.
     * @return List of Strings - the show times of the Show.
     */
    public String getShowTimes() {
        return showTimes;
    }
}
