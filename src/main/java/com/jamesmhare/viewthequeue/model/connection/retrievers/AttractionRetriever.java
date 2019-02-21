package com.jamesmhare.viewthequeue.model.connection.retrievers;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;

import java.util.List;

/**
 * Serves as an interface for the attraction retriever.
 */
public interface AttractionRetriever {

    /**
     * Searches for an attraction with a given name. Will return a list of only one attraction
     * or an empty list if more than one attraction is retrieved from the database.
     * @param attractionName the name of the attraction
     * @return the list of one single attraction.
     */
    List<Attraction> searchAttractionByName(String attractionName);

    /**
     * Searches for all attractions in a given Theme Park.
     * @param parkName the name of the Theme Park.
     * @return a List containing the matching attractions or null if none are found.
     */
    List<Attraction> searchAttractionByThemeParkName(String parkName);

    /**
     * Searches for all attractions in a given area.
     * @param area the name of the area.
     * @return a List containing the matching attractions or null if none are found.
     */
    List<Attraction> searchAttractionByArea(String area);

    /**
     * Searches for all attractions with a given operation status.
     * @param operationStatus the operation status of the attraction.
     * @return a List containing the matching attractions or null if none are found.
     */
    List<Attraction> searchAttractionByOperationStatus(String operationStatus);

    /**
     * Searches for all attractions with wheelchair accessibility.
     * @param wheelchairAccessible true for attractions with wheelchair accessibility, false if not.
     * @return a List containing the matching attractions or null if none are found.
     */
    List<Attraction> searchAttractionByWheelchairAccessibility(boolean wheelchairAccessible);

    /**
     * Searches for all attractions with an express line.
     * @param hasExpressLine true if the attraction has an express line, false if not.
     * @return a List containing the matching attractions or null if none are found.
     */
    List<Attraction> searchAttractionByExpressLine(boolean hasExpressLine);

    /**
     * Searches for all attractions with a single rider line.
     * @param hasSingleRiderLine true if the attraction has a single rider line, false if not.
     * @return a List containing the matching attractions or null if none are found.
     */
    List<Attraction> searchAttractionBySingleRiderLine(boolean hasSingleRiderLine);

    /**
     * Retrieves all the attractions.
     * @return a List containing all the attractions.
     */
    List<Attraction> retrieveAllAttractions();

}
