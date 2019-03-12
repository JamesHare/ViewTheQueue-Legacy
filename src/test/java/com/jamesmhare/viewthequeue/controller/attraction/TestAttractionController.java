package com.jamesmhare.viewthequeue.controller.attraction;

import com.jamesmhare.viewthequeue.utils.TestUtilities;
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
 * Serves as a test class for the {@link AttractionController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAttractionController {

    private MockMvc mockMvc;
    private static boolean databasePreviouslyExisted;
    private static TestUtilities testUtilities;

    @InjectMocks
    private AttractionController attractionController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(attractionController)
                .build();
    }

    @BeforeClass
    public static void setUpOnce() {
        testUtilities = new TestUtilities();
        databasePreviouslyExisted = testUtilities.databaseExists();
        if (databasePreviouslyExisted) {
            testUtilities.saveExistingAttractions();
            testUtilities.dropAttractionTable();
        } else {
            testUtilities.createDatabase();
        }
        testUtilities.createAttractionTable();
        testUtilities.populateAttractionTable();
    }

    @AfterClass
    public static void tearDownOnce() {
        testUtilities.dropAttractionTable();
        if (databasePreviouslyExisted) {
            testUtilities.createAttractionTable();
            testUtilities.restoreExistingAttractions();
        } else {
            testUtilities.dropDatabase();
        }
    }

    /**
     * Tests that the correct attraction is retrieved when given a valid attraction name.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByNameWhenNameValid() throws Exception {
        mockMvc.perform(get("/attraction?name=Test Attraction 1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid attraction name.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByNameWhenNameInvalid() throws Exception {
        mockMvc.perform(get("/attraction?name=Not A Valid Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid theme park name.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByParkWhenParkNameValid() throws Exception {
        mockMvc.perform(get("/attraction?parkname=Test Park")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[1].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[1].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid theme park name.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByParkWhenParkNameInvalid() throws Exception {
        mockMvc.perform(get("/attraction?parkname=Not A Valid Park")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid area name.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByAreaWhenAreaValid() throws Exception {
        mockMvc.perform(get("/attraction?area=Test Area")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[1].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[1].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid area name.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByAreaWhenAreaInvalid() throws Exception {
        mockMvc.perform(get("/attraction?area=Not A Valid Area")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid operation status of Open.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByOperationStatusWhenOperationStatusValidAndOpen() throws Exception {
        mockMvc.perform(get("/attraction?operationstatus=Open")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid operation status of closed.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByOperationStatusWhenOperationStatusValidAndClosed() throws Exception {
        mockMvc.perform(get("/attraction?operationstatus=Closed")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid operation status.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByOperationStatusWhenOperationStatusInvalid() throws Exception {
        mockMvc.perform(get("/attraction?operationstatus=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid wheelchair accessibility
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByWheelchairAccessibilityWhenWheelchairAccessibilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/attraction?wheelchairaccessible=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid wheelchair accessibility
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByWheelchairAccessibilityWhenWheelchairAccessibilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/attraction?wheelchairaccessible=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid wheelchair accessibility.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByWheelchairAccessibilityWhenWheelchairAccessibilityIsInvalid() throws Exception {
        mockMvc.perform(get("/attraction?wheelchairaccessible=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid express line availability
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByExpressLineAvailabilityWhenExpressLineAvailabilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/attraction?expressline=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid express line availability
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByExpressLineAvailabilityWhenExpressLineAvailabilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/attraction?expressline=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid express line availability.
     * @throws Exception
     */
    @Test
    public void testGetAttractionByExpressLineAvailabilityWhenExpressLineAvailabilityIsInvalid() throws Exception {
        mockMvc.perform(get("/attraction?expressline=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid single rider line availability
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetAttractionBySingleRiderLineAvailabilityWhenSingleRiderLineAvailabilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/attraction?singleriderline=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that the correct attractions are retrieved when given a valid single rider line availability
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetAttractionBySingleRiderLineAvailabilityWhenSingleRiderLineAvailabilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/attraction?singleriderline=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)));
    }

    /**
     * Tests that no attractions are retrieved when given an invalid single rider line availability.
     * @throws Exception
     */
    @Test
    public void testGetAttractionBySingleRiderLineAvailabilityWhenSingleRiderLineAvailabilityIsInvalid() throws Exception {
        mockMvc.perform(get("/attraction?singleriderline=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct attractions are retrieved when all attractions are requested.
     * @throws Exception
     */
    @Test
    public void testGetAllAttractions() throws Exception {
        mockMvc.perform(get("/attraction")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].attractionName", Matchers.is("Test Attraction 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].waitTime", Matchers.is(10)))
                .andExpect(jsonPath("$[0].maxHeightRestrictionInches", Matchers.is(50)))
                .andExpect(jsonPath("$[0].minHeightRestrictionInches", Matchers.is(40)))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].singleRider", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(13)))
                .andExpect(jsonPath("$[1].attractionName", Matchers.is("Test Attraction 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].waitTime", Matchers.is(0)))
                .andExpect(jsonPath("$[1].maxHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].minHeightRestrictionInches", Matchers.is(0)))
                .andExpect(jsonPath("$[1].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].singleRider", Matchers.is(true)))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(13)));
    }

}
