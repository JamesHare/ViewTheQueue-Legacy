package com.jamesmhare.viewthequeue.controller.show;

import com.jamesmhare.viewthequeue.model.connection.qualifiers.ShowQualifier;
import com.jamesmhare.viewthequeue.model.connection.retrievers.mysql.MySQLShowRetriever;
import com.jamesmhare.viewthequeue.model.show.Show;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves as a controller for {@link Show} based calls to the API.
 */
@RestController
@RequestMapping("/show")
public class ShowController {

    MySQLShowRetriever showRetriever = new MySQLShowRetriever();

    /**
     * Returns a JSON with information from the database matching the given parameters. A qualifier
     * is built that is given to the ShowRetriever which will be used to search for records
     * matching the given parameters.
     *
     * @param showName the name of a show.
     * @param parkName the name of the park in which the show is located.
     * @param area the name of the area in which the show is located.
     * @param operationStatus the operation status of the show. Can be Open or Closed.
     * @param isWheelchairAccessible the wheelchair accessibility of the show. Can be true or false.
     * @param hasExpressLine the express line availability of the show. Can be true or false.
     * @return all matching shows as a JSON.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Show>> getMatchingShows(
            @RequestParam(value="name", required=false) String showName,
            @RequestParam(value="parkname", required=false) String parkName,
            @RequestParam(value="area", required=false) String area,
            @RequestParam(value="operationstatus", required=false) String operationStatus,
            @RequestParam(value="wheelchairaccessible", required=false) Boolean isWheelchairAccessible,
            @RequestParam(value="expressline", required=false) Boolean hasExpressLine) {
        ShowQualifier showQualifier = new ShowQualifier.Builder()
                .withName(showName)
                .withParkName(parkName)
                .withArea(area)
                .withOperationStatus(operationStatus)
                .withWheelchairAccessibility(isWheelchairAccessible)
                .withExpressLine(hasExpressLine)
                .build();
        List<Show> shows = showRetriever.searchShows(showQualifier);
        if (shows.isEmpty()) {
            return new ResponseEntity<>(shows, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(shows, HttpStatus.OK);
        }
    }

}
