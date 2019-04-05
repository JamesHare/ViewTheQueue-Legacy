package com.jamesmhare.viewthequeue.controller.themepark;

import com.jamesmhare.viewthequeue.utils.themepark.ThemeParkTestUtilities;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Serves as a test class for the {@link ThemeParkController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestThemeParkController {

    private MockMvc mockMvc;
    private static boolean databasePreviouslyExisted;
    private static ThemeParkTestUtilities themeParkTestUtilities;

    @InjectMocks
    private ThemeParkController themeParkController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(themeParkController)
                .build();
    }

    @BeforeClass
    public static void setUpOnce() {
        themeParkTestUtilities = new ThemeParkTestUtilities();
        databasePreviouslyExisted = themeParkTestUtilities.databaseExists();
        if (databasePreviouslyExisted) {
            themeParkTestUtilities.saveExistingParkData();
            themeParkTestUtilities.dropParksDataTables();
        } else {
            themeParkTestUtilities.createDatabase();
        }
        themeParkTestUtilities.createParksTables();
        themeParkTestUtilities.populateParkDataTables();
    }

    @AfterClass
    public static void tearDownOnce() {
        themeParkTestUtilities.dropParksDataTables();
        if (databasePreviouslyExisted) {
            themeParkTestUtilities.createParksTables();
            themeParkTestUtilities.restoreExistingParkData();
        } else {
            themeParkTestUtilities.dropDatabase();
        }
    }

    /**
     * Tests that the correct park is retrieved when given a valid park name.
     * @throws Exception
     */
    @Test
    public void testGetThemeParkByNameWhenNameValid() throws Exception {
        mockMvc.perform(get("/park?name=test park 1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].attractions[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].attractions[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].attractions[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].attractions[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].attractions[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].attractions[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].attractions[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].attractions[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[0].restaurants[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].restaurants[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].restaurants[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].restaurants[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].restaurants[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].restaurants[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].restaurants[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].restaurants[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[0].shows[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].shows[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].shows[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].shows[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].shows[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].shows[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].shows[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].shows[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].shows[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no parks are retrieved when given an invalid park name.
     * @throws Exception
     */
    @Test
    public void testGetThemeParkByNameWhenNameInvalid() throws Exception {
        mockMvc.perform(get("/park?name=Not A Valid Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct parks are retrieved when given a valid operation status of Open.
     * @throws Exception
     */
    @Test
    public void testGetThemeParkByOperationStatusWhenOperationStatusValidAndOpen() throws Exception {
        mockMvc.perform(get("/park?operationstatus=Open")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].attractions[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].attractions[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].attractions[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].attractions[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].attractions[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].attractions[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].attractions[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].attractions[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[0].restaurants[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].restaurants[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].restaurants[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].restaurants[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].restaurants[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].restaurants[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].restaurants[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].restaurants[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[0].shows[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].shows[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].shows[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].shows[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].shows[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].shows[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].shows[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].shows[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].shows[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that the correct parks are retrieved when given a valid operation status of closed.
     * @throws Exception
     */
    @Test
    public void testGetThemeParkByOperationStatusWhenOperationStatusValidAndClosed() throws Exception {
        mockMvc.perform(get("/park?operationstatus=Closed")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("09:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("21:30:00")))
                .andExpect(jsonPath("$[0].attractions[0].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[0].attractions[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].attractions[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].attractions[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].attractions[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].attractions[0].openingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[0].attractions[0].closingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[0].attractions[0].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[0].attractions[0].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].attractions[0].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].attractions[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].attractions[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].attractions[0].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[0].attractions[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[0].restaurants[0].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[0].restaurants[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].restaurants[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].restaurants[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].restaurants[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].restaurants[0].openingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[0].restaurants[0].closingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[0].restaurants[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[0].shows[0].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[0].shows[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].shows[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].shows[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].shows[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].shows[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].shows[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].shows[0].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[0].shows[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no parks are retrieved when given an invalid operation status.
     * @throws Exception
     */
    @Test
    public void testGetThemeParkByOperationStatusWhenOperationStatusInvalid() throws Exception {
        mockMvc.perform(get("/park?operationstatus=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct parks are retrieved when all parks are requested.
     * @throws Exception
     */
    @Test
    public void testGetAllParks() throws Exception {
        mockMvc.perform(get("/park")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].attractions[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].attractions[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].attractions[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].attractions[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].attractions[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].attractions[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].attractions[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].attractions[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].attractions[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].attractions[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[0].restaurants[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].restaurants[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].restaurants[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].restaurants[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].restaurants[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].restaurants[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].restaurants[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].restaurants[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].restaurants[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[0].shows[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].shows[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].shows[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].shows[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].shows[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].shows[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].shows[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].shows[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].shows[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].openingTime", Matchers.is("09:00:00")))
                .andExpect(jsonPath("$[1].closingTime", Matchers.is("21:30:00")))
                .andExpect(jsonPath("$[1].attractions[0].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[1].attractions[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].attractions[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[1].attractions[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].attractions[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].attractions[0].openingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[1].attractions[0].closingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[1].attractions[0].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[1].attractions[0].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].attractions[0].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].attractions[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].attractions[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].attractions[0].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[1].attractions[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[1].restaurants[0].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[1].restaurants[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].restaurants[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[1].restaurants[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].restaurants[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].restaurants[0].openingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[1].restaurants[0].closingTime", Matchers.isEmptyOrNullString()))
                .andExpect(jsonPath("$[1].restaurants[0].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[1].restaurants[0].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[1].restaurants[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[1].shows[0].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[1].shows[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].shows[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[1].shows[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].shows[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].shows[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].shows[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].shows[0].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[1].shows[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(8)));
    }
}
