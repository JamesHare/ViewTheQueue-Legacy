package com.jamesmhare.viewthequeue.model.attraction;

/**
 * Serves as a class for an attraction POJO.
 */
public class Attraction {

    private String attractionName, description, parkName, area, operationStatus, openingTime, closingTime;
    private int waitTime, maxHeightRestrictionInches, minHeightRestrictionInches;
    private boolean isWheelchairAccessible, hasExpressLine, hasSingleRider;

    private Attraction(Builder builder) {
        this.attractionName = builder.attractionName;
        this.description = builder.description;
        this.parkName = builder.parkName;
        this.area = builder.area;
        this.operationStatus = builder.operationStatus;
        this.openingTime = builder.openingTime;
        this.closingTime = builder.closingTime;
        this.waitTime = builder.waitTime;
        this.maxHeightRestrictionInches = builder.maxHeightRestrictionInches;
        this.minHeightRestrictionInches = builder.minHeightRestrictionInches;
        this.isWheelchairAccessible = builder.isWheelchairAccessible;
        this.hasExpressLine = builder.hasExpressLine;
        this.hasSingleRider = builder.hasSingleRider;
    }

    /**
     * Serves as a static builder class to build an Attraction POJO.
     */
    public static class Builder {

        private String attractionName, description, parkName, area, operationStatus, openingTime, closingTime;
        private int waitTime, maxHeightRestrictionInches, minHeightRestrictionInches;
        private boolean isWheelchairAccessible, hasExpressLine, hasSingleRider;

        public Builder() {}

        /**
         * Sets the name of the attraction.
         * @param attractionName the name of the attraction.
         * @return the Builder object.
         */
        public Builder withName(String attractionName) {
            this.attractionName = attractionName;
            return this;
        }

        /**
         * Sets the description of the attraction.
         * @param description the description of the attraction.
         * @return the Builder object.
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the name of the Theme Park that the attraction belongs to.
         * @param parkName the name of the Theme Park that the attraction belongs to.
         * @return the Builder object.
         */
        public Builder withParkName(String parkName) {
            this.parkName = parkName;
            return this;
        }

        /**
         * Sets the name of the area that the attraction belongs to.
         * @param area the name of the area that the attraction belongs to.
         * @return the Builder object.
         */
        public Builder withArea(String area) {
            this.area = area;
            return this;
        }

        /**
         * Sets the operation status of the attraction.
         * @param operationStatus the operation status of the attraction.
         * @return the Builder object.
         */
        public Builder withOperationStatus(String operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        /**
         * Sets the opening time of the attraction.
         * @param openingTime the opening time of the attraction.
         * @return the Builder object.
         */
        public Builder withOpeningTime(String openingTime) {
            this.openingTime = openingTime;
            return this;
        }

        /**
         * Sets the closing time of the attraction.
         * @param closingTime the closing time of the attraction.
         * @return the Builder object.
         */
        public Builder withClosingTime(String closingTime) {
            this.closingTime = closingTime;
            return this;
        }

        /**
         * Sets the wait time of the attraction.
         * @param waitTime the wait time of the attraction.
         * @return the Builder object.
         */
        public Builder withWaitTime(int waitTime) {
            this.waitTime = waitTime;
            return this;
        }

        /**
         * Sets the maximum height restriction of the attraction in inches.
         * @param maxHeightRestrictionInches the maximum height restriction of the attraction in inches.
         * @return the Builder object.
         */
        public Builder withMaxHeightRestrictionInInches(int maxHeightRestrictionInches) {
            this.maxHeightRestrictionInches = maxHeightRestrictionInches;
            return this;
        }

        /**
         * Sets the minimum height restriction of the attraction in inches.
         * @param minHeightRestrictionInches the minimum height restriction of the attraction in inches.
         * @return the Builder object.
         */
        public Builder withMinHeightRestrictionInInches(int minHeightRestrictionInches) {
            this.minHeightRestrictionInches = minHeightRestrictionInches;
            return this;
        }

        /**
         * Sets the wheelchair accessibility of the attraction.
         * @param isWheelchairAccessible the wheelchair accessibility of the attraction.
         * @return the Builder object.
         */
        public Builder withWheelchairAccessibility(boolean isWheelchairAccessible) {
            this.isWheelchairAccessible = isWheelchairAccessible;
            return this;
        }

        /**
         * Sets if there is an express line for the attraction or not.
         * @param hasExpressLine true if there is an express line, false if there is not.
         * @return the Builder object.
         */
        public Builder withExpressLine(boolean hasExpressLine) {
            this.hasExpressLine = hasExpressLine;
            return this;
        }

        /**
         * Sets if there is a single rider line for the attraction or not.
         * @param hasSingleRider true if there is a single rider line, false if there is not.
         * @return the Builder object.
         */
        public Builder withSingleRiderLine(boolean hasSingleRider) {
            this.hasSingleRider = hasSingleRider;
            return this;
        }

        /**
         * Builds the Attraction object using the builder.
         * @return the Attraction object.
         */
        public Attraction build() {
            return new Attraction(this);
        }
    }

    /**
     * Returns the name of the attraction.
     * @return the name of the attraction.
     */
    public String getAttractionName() {
        return attractionName;
    }

    /**
     * Returns the description of the attraction.
     * @return the description of the attraction.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the Theme Park that the attraction belongs to.
     * @return the name of the Theme Park that the attraction belongs to.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Returns the area of the attraction.
     * @return the area of the attraction.
     */
    public String getArea() {
        return area;
    }

    /**
     * Returns the operation status of the attraction.
     * @return the operation status of the attraction.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

    /**
     * Returns the opening time of the attraction.
     * @return the opening time of the attraction.
     */
    public String getOpeningTime() {
        return openingTime;
    }

    /**
     * Returns the closing time of the attraction.
     * @return the closing time of the attraction.
     */
    public String getClosingTime() {
        return closingTime;
    }

    /**
     * Returns the wait time of the attraction.
     * @return the wait time of the attraction.
     */
    public int getWaitTime() {
        return waitTime;
    }

    /**
     * Returns the maximum height restriction of the attraction in inches.
     * @return the maximum height restriction of the attraction in inches.
     */
    public int getMaxHeightRestrictionInches() {
        return maxHeightRestrictionInches;
    }

    /**
     * Returns the minimum height restriction of the attraction in inches.
     * @return the minimum height restriction of the attraction in inches.
     */
    public int getMinHeightRestrictionInches() {
        return minHeightRestrictionInches;
    }

    /**
     * Returns the wheelchair accessibility of the attraction.
     * @return true if the attraction is wheelchair accessible.
     */
    public boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    /**
     * Returns if there is an express line for the attraction or not.
     * @return true if there is an express line for the attraction.
     */
    public boolean isExpressLine() {
        return hasExpressLine;
    }

    /**
     * Returns if there is a single rider line for the attraction or not.
     * @return true if there is a single rider line for the attraction.
     */
    public boolean isSingleRider() {
        return hasSingleRider;
    }
}
