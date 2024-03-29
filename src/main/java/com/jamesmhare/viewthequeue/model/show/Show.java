package com.jamesmhare.viewthequeue.model.show;

/**
 * Serves as a class for a Show POJO.
 */
public class Show {

    private String showName, description, parkName, area, operationStatus, showTimes;
    private boolean isWheelchairAccessible, hasExpressLine;

    private Show(Builder builder) {
        this.showName = builder.showName;
        this.description = builder.description;
        this.parkName = builder.parkName;
        this.area = builder.area;
        this.operationStatus = builder.operationStatus;
        this.showTimes = builder.showTimes;
        this.isWheelchairAccessible = builder.isWheelchairAccessible;
        this.hasExpressLine = builder.hasExpressLine;
    }

    /**
     * Serves as a static builder class to build a Show POJO.
     */
    public static class Builder {

        private String showName, description, parkName, area, operationStatus, showTimes;
        private boolean isWheelchairAccessible, hasExpressLine;

        public Builder() {}

        /**
         * Sets the name of the show.
         * @param showName the name of the show.
         * @return the Builder object.
         */
        public Builder withName(String showName) {
            this.showName = showName;
            return this;
        }

        /**
         * Sets the description of the show.
         * @param description the description of the show.
         * @return the Builder object.
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the name of the Theme Park that the show belongs to.
         * @param parkName the name of the Theme Park that the show belongs to.
         * @return the Builder object.
         */
        public Builder withParkName(String parkName) {
            this.parkName = parkName;
            return this;
        }

        /**
         * Sets the name of the area that the show belongs to.
         * @param area the name of the area that the show belongs to.
         * @return the Builder object.
         */
        public Builder withArea(String area) {
            this.area = area;
            return this;
        }

        /**
         * Sets the operation status of the show.
         * @param operationStatus the operation status of the show.
         * @return the Builder object.
         */
        public Builder withOperationStatus(String operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        /**
         * Sets the show times of the show.
         * @param showTimes the show times of the show.
         * @return the Builder object.
         */
        public Builder withShowTimes(String showTimes) {
            this.showTimes = showTimes;
            return this;
        }

        /**
         * Sets the wheelchair accessibility of the show.
         * @param isWheelchairAccessible the wheelchair accessibility of the show.
         * @return the Builder object.
         */
        public Builder withWheelchairAccessibility(boolean isWheelchairAccessible) {
            this.isWheelchairAccessible = isWheelchairAccessible;
            return this;
        }

        /**
         * Sets if there is an express line for the show or not.
         * @param hasExpressLine true if there is an express line, false if there is not.
         * @return the Builder object.
         */
        public Builder withExpressLine(boolean hasExpressLine) {
            this.hasExpressLine = hasExpressLine;
            return this;
        }

        /**
         * Builds the Show object using the builder.
         * @return the show object.
         */
        public Show build() {
            return new Show(this);
        }
    }

    /**
     * Returns the name of the Show.
     * @return the name of the Show.
     */
    public String getShowName() {
        return showName;
    }

    /**
     * Returns the description of the Show.
     * @return the description of the Show.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the park name that the Show belongs to.
     * @return the park name that the Show belongs to.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Returns the area of the Show.
     * @return the area of the Show.
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns the operation status of the Show.
     * @return the operation status of the Show.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the show times of the Show.
     * @return the show times of the Show.
     */
    public String getShowTimes() {
        return showTimes;
    }

    /**
     * Returns the wheelchair accessibility of the Show.
     * @return true is the Show is wheelchair accessible.
     */
    public boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    /**
     * Returns there is an express line for the Show.
     * @return true if there is an express line for the Show.
     */
    public boolean isExpressLine() {
        return hasExpressLine;
    }
}
