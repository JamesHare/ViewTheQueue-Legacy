package com.jamesmhare.viewthequeue.model.connection.retrievers;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.qualifiers.AttractionQualifier;

import java.util.List;

/**
 * Serves as an interface for the attraction retriever.
 */
public interface AttractionRetriever {

    /**
     * Searches for an attraction given an {@code AttractionQualifier} object.
     * @param attractionQualifier an AttractionQualifier object.
     * @return a List of matching attractions.
     */
    List<Attraction> searchAttractions(AttractionQualifier attractionQualifier);

}
