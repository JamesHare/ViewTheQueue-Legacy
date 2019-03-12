package com.jamesmhare.viewthequeue.controller.attraction;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.connection.qualifiers.AttractionQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.mysql.MySQLAttractionRetriever;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves as a controller for {@link Attraction} based calls to the API.
 */
@RestController
@RequestMapping("/attraction")
public class AttractionController {

    MySQLAttractionRetriever attractionRetriever = new MySQLAttractionRetriever();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Attraction>> getMatchingAttractions(
            @RequestParam(value="name", required=false) String attractionName,
            @RequestParam(value="parkname", required=false) String parkName,
            @RequestParam(value="area", required=false) String area,
            @RequestParam(value="operationstatus", required=false) String operationStatus,
            @RequestParam(value="wheelchairaccessible", required=false) Boolean isWheelchairAccessible,
            @RequestParam(value="expressline", required=false) Boolean hasExpressLine,
            @RequestParam(value="singleriderline", required=false) Boolean hasSingleRider) {
        AttractionQualifier attractionQualifier = new AttractionQualifier.Builder()
                .withName(attractionName)
                .withParkName(parkName)
                .withArea(area)
                .withOperationStatus(operationStatus)
                .withWheelchairAccessibility(isWheelchairAccessible)
                .withExpressLine(hasExpressLine)
                .withSingleRiderLine(hasSingleRider)
                .build();
        List<Attraction> attractions = attractionRetriever.searchAttractions(attractionQualifier);
        if (attractions.isEmpty()) {
            return new ResponseEntity<>(attractions, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attractions, HttpStatus.OK);
        }
    }

}
