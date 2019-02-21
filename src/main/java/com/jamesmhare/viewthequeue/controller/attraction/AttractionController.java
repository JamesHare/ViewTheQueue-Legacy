package com.jamesmhare.viewthequeue.controller.attraction;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.retrievers.mysql.MySQLAttractionRetriever;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves as a controller for {@link Attraction} based calls to the API.
 */
@RestController
public class AttractionController {

    MySQLAttractionRetriever attractionRetriever = new MySQLAttractionRetriever();

    /**
     * Makes a request to the API for an {@link Attraction} given an Attraction name.
     * @param name the name of the Attraction.
     * @return the matching Attraction.
     */
    @GetMapping(value = "/attraction-with-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionByName(@RequestParam(value="name", defaultValue="null") String name) {
        List<Attraction> attractions = attractionRetriever.searchAttractionByName(name);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for an {@link Attraction} given a Theme Park.
     * @param themeParkName the Theme Park in which the Attraction is located.
     * @return all matching Attractions.
     */
    @GetMapping(value = "/attractions-in-park", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionsByThemePark(@RequestParam(value="park-name", defaultValue="null") String themeParkName) {
        List<Attraction> attractions = attractionRetriever.searchAttractionByThemeParkName(themeParkName);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for an {@link Attraction} given an area.
     * @param area the area in which the Attraction is located.
     * @return all matching Attractions.
     */
    @GetMapping(value = "/attractions-in-area", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionsByArea(@RequestParam(value="area", defaultValue="null") String area) {
        List<Attraction> attractions = attractionRetriever.searchAttractionByArea(area);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for an {@link Attraction} given an operation status.
     * @param operationStatus the operation status of the Attraction
     * @return all matching Attractions.
     */
    @GetMapping(value = "/attractions-with-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionsByOperationStatus(@RequestParam(value="status", defaultValue="null") String operationStatus) {
        List<Attraction> attractions = attractionRetriever.searchAttractionByOperationStatus(operationStatus);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for an {@link Attraction} given the wheelchair accessibility.
     * @param wheelchairAccessible the wheelchair accessibility of the Attraction
     * @return all matching Attractions.
     */
    @GetMapping(value = "/attractions-with-wheelchair-access", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionsByWheelchairAccessibility(@RequestParam(value="wheelchair-access", defaultValue="null") boolean wheelchairAccessible) {
        List<Attraction> attractions = attractionRetriever.searchAttractionByWheelchairAccessibility(wheelchairAccessible);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for an {@link Attraction} given the express line availability.
     * @param hasExpressLine the express line availability of the Attraction
     * @return all matching Attractions.
     */
    @GetMapping(value = "/attractions-with-express", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionsByExpressLine(@RequestParam(value="express", defaultValue="null") boolean hasExpressLine) {
        List<Attraction> attractions = attractionRetriever.searchAttractionByExpressLine(hasExpressLine);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for an {@link Attraction} given the single rider line availability.
     * @param hasSingleRider the single rider line availability of the Attraction
     * @return all matching Attractions.
     */
    @GetMapping(value = "/attractions-with-single-rider", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> attractionsBySingleRiderLine(@RequestParam(value="single-rider", defaultValue="null") boolean hasSingleRider) {
        List<Attraction> attractions = attractionRetriever.searchAttractionBySingleRiderLine(hasSingleRider);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

    /**
     * Makes a request to the API for all {@link Attraction} objects in the database.
     * @return all Attractions.
     */
    @GetMapping(value = "/attractions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> allAttractions() {
        List<Attraction> attractions = attractionRetriever.retrieveAllAttractions();
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

}
