package com.jamesmhare.viewthequeue.controller.show;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Serves as a test class for the {@link ShowController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestShowController {

    private MockMvc mockMvc;
    private static boolean databasePreviouslyExisted;
    private static TestUtilities testUtilities;

    @InjectMocks
    private ShowController showController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(showController)
                .build();
    }

    @BeforeClass
    public static void setUpOnce() {
        testUtilities = new TestUtilities();
        databasePreviouslyExisted = testUtilities.databaseExists();
        if (databasePreviouslyExisted) {
            testUtilities.saveExistingShows();
            testUtilities.dropShowTable();
        } else {
            testUtilities.createDatabase();
        }
        testUtilities.createShowTable();
        testUtilities.populateShowTable();
    }

    @AfterClass
    public static void tearDownOnce() {
        testUtilities.dropShowTable();
        if (databasePreviouslyExisted) {
            testUtilities.createShowTable();
            testUtilities.restoreExistingShows();
        } else {
            testUtilities.dropDatabase();
        }
    }

    /**
     * Tests that the correct show is retrieved when given a valid show name.
     * @throws Exception
     */
    @Test
    public void testGetShowByNameWhenNameValid() throws Exception {
        mockMvc.perform(get("/show?name=Test Show 1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no shows are retrieved when given an invalid show name.
     * @throws Exception
     */
    @Test
    public void testGetShowByNameWhenNameInvalid() throws Exception {
        mockMvc.perform(get("/show?name=Not A Valid Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct shows are retrieved when given a valid theme park name.
     * @throws Exception
     */
    @Test
    public void testGetShowByParkWhenParkNameValid() throws Exception {
        mockMvc.perform(get("/show?parkname=Test Park")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[1].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no shows are retrieved when given an invalid theme park name.
     * @throws Exception
     */
    @Test
    public void testGetShowByParkWhenParkNameInvalid() throws Exception {
        mockMvc.perform(get("/show?parkname=Not A Valid Park")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct shows are retrieved when given a valid area name.
     * @throws Exception
     */
    @Test
    public void testGetShowByAreaWhenAreaValid() throws Exception {
        mockMvc.perform(get("/show?area=Test Area")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[1].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no shows are retrieved when given an invalid area name.
     * @throws Exception
     */
    @Test
    public void testGetShowByAreaWhenAreaInvalid() throws Exception {
        mockMvc.perform(get("/show?area=Not A Valid Area")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct shows are retrieved when given a valid operation status of open.
     * @throws Exception
     */
    @Test
    public void testGetShowByOperationStatusWhenOperationStatusValidAndOpen() throws Exception {
        mockMvc.perform(get("/show?operationstatus=Open")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that the correct shows are retrieved when given a valid operation status of closed.
     * @throws Exception
     */
    @Test
    public void testGetShowByOperationStatusWhenOperationStatusValidAndClosed() throws Exception {
        mockMvc.perform(get("/show?operationstatus=Closed")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no shows are retrieved when given an invalid operation status.
     * @throws Exception
     */
    @Test
    public void testGetShowByOperationStatusWhenOperationStatusInvalid() throws Exception {
        mockMvc.perform(get("/show?operationstatus=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct shows are retrieved when given a valid wheelchair accessibility
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetShowByWheelchairAccessibilityWhenWheelchairAccessibilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/show?wheelchairaccessible=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that the correct shows are retrieved when given a valid wheelchair accessibility
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetShowByWheelchairAccessibilityWhenWheelchairAccessibilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/show?wheelchairaccessible=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no shows are retrieved when given an invalid wheelchair accessibility.
     * @throws Exception
     */
    @Test
    public void testGetShowByWheelchairAccessibilityWhenWheelchairAccessibilityIsInvalid() throws Exception {
        mockMvc.perform(get("/show?wheelchairaccessible=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct shows are retrieved when given a valid express line availability
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetShowByExpressLineAvailabilityWhenExpressLineAvailabilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/show?expressline=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that the correct shows are retrieved when given a valid express line availability
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetShowByExpressLineAvailabilityWhenExpressLineAvailabilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/show?expressline=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)));
    }

    /**
     * Tests that no shows are retrieved when given an invalid express line availability.
     * @throws Exception
     */
    @Test
    public void testGetShowByExpressLineAvailabilityWhenExpressLineAvailabilityIsInvalid() throws Exception {
        mockMvc.perform(get("/show?expressline=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct shows are retrieved when all shows are requested.
     * @throws Exception
     */
    @Test
    public void testGetAllShows() throws Exception {
        mockMvc.perform(get("/show")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].showName", Matchers.is("Test Show 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].wheelchairAccessible", Matchers.is(false)))
                .andExpect(jsonPath("$[0].expressLine", Matchers.is(false)))
                .andExpect(jsonPath("$[0].showTimes", Matchers.is("10:00, 14:30, 17:00")))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(8)))
                .andExpect(jsonPath("$[1].showName", Matchers.is("Test Show 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].wheelchairAccessible", Matchers.is(true)))
                .andExpect(jsonPath("$[1].expressLine", Matchers.is(true)))
                .andExpect(jsonPath("$[1].showTimes", Matchers.is("11:30, 15:00, 18:00")))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(8)));
    }

}
