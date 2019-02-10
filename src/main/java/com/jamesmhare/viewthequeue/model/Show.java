package com.jamesmhare.viewthequeue.model;

import java.util.List;

/**
 * Serves as an abstract class for a Show object.
 */
abstract class Show {

    private String name;
    private String description;
    private String area;
    private String operationStatus;
    private boolean isWheelchairAccessible;
    private boolean hasExpressLine;
    private List<String> showTimes;

    private final void update() {
        updateDescription();
        updateOperationStatus();
        updateIsWheelchairAccessible();
        updateHasExpressLine();
        updateShowTimes();
    }

    abstract void updateDescription();

    abstract void updateOperationStatus();

    abstract void updateIsWheelchairAccessible();

    abstract void updateHasExpressLine();

    abstract void updateShowTimes();

    /**
     * Returns the name of the Show.
     * @return String - the name of the Show.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the Show.
     * @return String - the description of the Show.
     */
    public String getDescription() {
        return description;
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
