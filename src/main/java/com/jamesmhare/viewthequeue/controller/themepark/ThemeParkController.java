package com.jamesmhare.viewthequeue.controller.themepark;

import com.jamesmhare.viewthequeue.model.connection.qualifiers.ThemeParkQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.ThemeParkRetriever;
import com.jamesmhare.viewthequeue.model.connection.retrievers.mysql.MySQLThemeParkRetriever;
import com.jamesmhare.viewthequeue.model.themepark.ThemePark;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves as a controller for {@link ThemePark} based calls to the API.
 */
@RestController
@RequestMapping("/park")
public class ThemeParkController {

    ThemeParkRetriever themeParkRetriever = new MySQLThemeParkRetriever();

    /**
     * Returns a JSON with information from the database matching the given parameters. A qualifier
     * is built that is given to the ThemeParkRetriever which will be used to search for records
     * matching the given parameters.
     *
     * @param parkName the name of a theme park.
     * @param operationStatus the operation status of the theme park. Can be Open or Closed.
     * @return all matching theme parks as a JSON.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ThemePark>> getMatchingThemeParks(
            @RequestParam(value="name", required=false) String parkName,
            @RequestParam(value="operationstatus", required=false) String operationStatus) {
        ThemeParkQualifier themeParkQualifier = new ThemeParkQualifier.Builder()
                .withName(parkName)
                .withOperationStatus(operationStatus)
                .build();
        List<ThemePark> parks = themeParkRetriever.searchThemeParks(themeParkQualifier);
        if (parks.isEmpty()) {
            return new ResponseEntity<>(parks, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(parks, HttpStatus.OK);
        }
    }

}
