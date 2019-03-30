package com.jamesmhare.viewthequeue.model.connection.qualifiers;

/**
 * Serves as a way to hold search qualifiers for the Show object.
 * The controller will build a qualifier with the attributes given at the end point and pass it into the {@code ShowRetriever}
 * for searching the database.
 */
public class ShowQualifier {

    private String showName, parkName, area, operationStatus;
    private Boolean isWheelchairAccessible, hasExpressLine;

    private ShowQualifier(Builder builder) {
        this.showName = builder.showName;
        this.parkName = builder.parkName;
        this.area = builder.area;
        this.operationStatus = builder.operationStatus;
        this.isWheelchairAccessible = builder.isWheelchairAccessible;
        this.hasExpressLine = builder.hasExpressLine;
    }

    /**
     * Serves as a static builder class to build a ShowQualifier.
     */
    public static class Builder {

        private String showName, parkName, area, operationStatus;
        private Boolean isWheelchairAccessible, hasExpressLine;

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
         * Sets the wheelchair accessibility of the show.
         * @param isWheelchairAccessible the wheelchair accessibility of the show.
         * @return the Builder object.
         */
        public Builder withWheelchairAccessibility(Boolean isWheelchairAccessible) {
            this.isWheelchairAccessible = isWheelchairAccessible;
            return this;
        }

        /**
         * Sets if there is an express line for the show or not.
         * @param hasExpressLine true if there is an express line, false if there is not.
         * @return the Builder object.
         */
        public Builder withExpressLine(Boolean hasExpressLine) {
            this.hasExpressLine = hasExpressLine;
            return this;
        }

        /**
         * Builds the ShowQualifier object using the builder.
         * @return the ShowQualifier object.
         */
        public ShowQualifier build() {
            return new ShowQualifier(this);
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
     * Returns the wheelchair accessibility of the Show.
     * @return true is the Show is wheelchair accessible.
     */
    public Boolean isWheelchairAccessible() {
        return isWheelchairAccessible;
    }

    /**
     * Returns there is an express line for the Show.
     * @return true if there is an express line for the Show.
     */
    public Boolean isExpressLine() {
        return hasExpressLine;
    }

}
