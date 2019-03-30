package com.jamesmhare.viewthequeue.model.connection.retrievers;

import com.jamesmhare.viewthequeue.model.connection.qualifiers.ShowQualifier;
import com.jamesmhare.viewthequeue.model.show.Show;

import java.util.List;

/**
 * Serves as an interface for the show retriever.
 */
public interface ShowRetriever {

    /**
     * Searches for an show given a {@code ShowQualifier} object.
     * @param showQualifier a ShowQualifier object.
     * @return a List of matching Shows.
     */
    List<Show> searchShows(ShowQualifier showQualifier);

}
