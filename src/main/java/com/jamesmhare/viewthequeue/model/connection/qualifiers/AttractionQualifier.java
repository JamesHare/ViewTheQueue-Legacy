package com.jamesmhare.viewthequeue.model.connection.qualifiers;

/**
 * Serves as a way to hold search qualifiers for the Attraction object.
 * The controller will build a qualifier with the attributes given at the end point and pass it into the {@code AttractionRetriever}
 * for searching the database.
 */
public class AttractionQualifier {

    private String attractionName, parkName, area, operationStatus;
    private Boolean isWheelchairAccessible, hasExpressLine, hasSingleRider;

    private AttractionQualifier(Builder builder) {
        this.attractionName = builder.attractionName;
        this.parkName = builder.parkName;
        this.area = builder.area;
        this.operationStatus = builder.operationStatus;
        this.isWheelchairAccessible = builder.isWheelchairAccessible;
        this.hasExpressLine = builder.hasExpressLine;
        this.hasSingleRider = builder.hasSingleRider;
    }

    /**
     * Serves as a static builder class to build an AttractionQualifier.
     */
    public static class Builder {

        private String attractionName, parkName, area, operationStatus;
        private Boolean isWheelchairAccessible, hasExpressLine, hasSingleRider;

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
         * Sets the wheelchair accessibility of the attraction.
         * @param isWheelchairAccessible the wheelchair accessibility of the attraction.
         * @return the Builder object.
         */
        public Builder withWheelchairAccessibility(Boolean isWheelchairAccessible) {
            this.isWheelchairAccessible = isWheelchairAccessible;
            return this;
        }

        /**
         * Sets if there is an express line for the attraction or not.
         * @param hasExpressLine true if there is an express line, false if there is not.
         * @return the Builder object.
         */
        public Builder withExpressLine(Boolean hasExpressLine) {
            this.hasExpressLine = hasExpressLine;
            return this;
        }

        /**
         * Sets if there is a single rider line for the attraction or not.
         * @param hasSingleRider true if there is a single rider line, false if there is not.
         * @return the Builder object.
         */
        public Builder withSingleRiderLine(Boolean hasSingleRider) {
            this.hasSingleRider = hasSingleRider;
            return this;
        }

        /**
         * Builds the AttractionQualifier object using the builder.
         * @return the AttractionQualifier object.
         */
        public AttractionQualifier build() {
            return new AttractionQualifier(this);
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
     * Returns the wheelchair accessibility of the attraction.
     * @return true if the attraction is wheelchair accessible.
     */
    public Boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    /**
     * Returns if there is an express line for the attraction or not.
     * @return true if there is an express line for the attraction.
     */
    public Boolean isExpressLine() {
        return hasExpressLine;
    }

    /**
     * Returns if there is a single rider line for the attraction or not.
     * @return true if there is a single rider line for the attraction.
     */
    public Boolean isSingleRider() {
        return hasSingleRider;
    }

}
