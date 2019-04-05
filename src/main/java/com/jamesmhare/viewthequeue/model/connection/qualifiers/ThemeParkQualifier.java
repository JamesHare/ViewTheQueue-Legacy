package com.jamesmhare.viewthequeue.model.connection.qualifiers;

/**
 * Serves as a way to hold search qualifiers for the ThemePark object.
 * The controller will build a qualifier with the attributes given at the end point and pass it into the {@code ThemeParkRetriever}
 * for searching the database.
 */
public class ThemeParkQualifier {

    private String parkName, operationStatus;

    private ThemeParkQualifier(Builder builder) {
        this.parkName = builder.parkName;
        this.operationStatus = builder.operationStatus;
    }

    /**
     * Serves as a static builder class to build a ThemeParkQualifier.
     */
    public static class Builder {

        private String parkName, operationStatus;

        public Builder() {}

        /**
         * Sets the name of the theme park.
         * @param parkName the name of the theme park.
         * @return the Builder object.
         */
        public Builder withName(String parkName) {
            this.parkName = parkName;
            return this;
        }

        /**
         * Sets the operation status of the theme park.
         * @param operationStatus the operation status of the theme park.
         * @return the Builder object.
         */
        public Builder withOperationStatus(String operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        /**
         * Builds the ThemeParkQualifier object using the builder.
         * @return the ThemeParkQualifier object.
         */
        public ThemeParkQualifier build() {
            return new ThemeParkQualifier(this);
        }

    }

    /**
     * Returns the name of the theme park.
     * @return the name of the theme park.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Returns the operation status of the theme park.
     * @return the operation status of the theme park.
     */
    public String getOperationStatus() {
        return operationStatus;
    }

}
