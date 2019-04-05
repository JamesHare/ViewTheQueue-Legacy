package com.jamesmhare.viewthequeue.model.connection.retrievers;

import com.jamesmhare.viewthequeue.model.connection.qualifiers.ThemeParkQualifier;
import com.jamesmhare.viewthequeue.model.themepark.ThemePark;

import java.util.List;

/**
 * Serves as an interface for the theme park retriever.
 */
public interface ThemeParkRetriever {

    /**
     * Searches for a theme park given a {@code ThemeParkQualifier} object.
     * @param themeParkQualifier a ThemeParkQualifier object.
     * @return a List of matching theme parks.
     */
    List<ThemePark> searchThemeParks(ThemeParkQualifier themeParkQualifier);

}
