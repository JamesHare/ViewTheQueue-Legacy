package com.jamesmhare.viewthequeue.controller.restaurant;

import com.jamesmhare.viewthequeue.utils.restaurant.RestaurantTestUtilities;
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
 * Serves as a test class for the {@link RestaurantController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRestaurantController {

    private MockMvc mockMvc;
    private static boolean databasePreviouslyExisted;
    private static RestaurantTestUtilities restaurantTestUtilities;

    @InjectMocks
    private RestaurantController restaurantController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController)
                .build();
    }

    @BeforeClass
    public static void setUpOnce() {
        restaurantTestUtilities = new RestaurantTestUtilities();
        databasePreviouslyExisted = restaurantTestUtilities.databaseExists();
        if (databasePreviouslyExisted) {
            restaurantTestUtilities.saveExistingRestaurants();
            restaurantTestUtilities.dropRestaurantTable();
        } else {
            restaurantTestUtilities.createDatabase();
        }
        restaurantTestUtilities.createRestaurantTable();
        restaurantTestUtilities.populateRestaurantTable();
    }

    @AfterClass
    public static void tearDownOnce() {
        restaurantTestUtilities.dropRestaurantTable();
        if (databasePreviouslyExisted) {
            restaurantTestUtilities.createRestaurantTable();
            restaurantTestUtilities.restoreExistingRestaurants();
        } else {
            restaurantTestUtilities.dropDatabase();
        }
    }

    /**
     * Tests that the correct restaurant is retrieved when given a valid restaurant name.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByNameWhenNameValid() throws Exception {
        mockMvc.perform(get("/restaurant?name=Test Restaurant 1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that no restaurants are retrieved when given an invalid restaurant name.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByNameWhenNameInvalid() throws Exception {
        mockMvc.perform(get("/restaurant?name=Not A Valid Name")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid theme park name.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByParkWhenParkNameValid() throws Exception {
        mockMvc.perform(get("/restaurant?parkname=Test Park 1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that no restaurants are retrieved when given an invalid theme park name.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByParkWhenParkNameInvalid() throws Exception {
        mockMvc.perform(get("/restaurant?parkname=Not A Valid Park")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid area name.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantsByAreaWhenAreaValid() throws Exception {
        mockMvc.perform(get("/restaurant?area=Test Area")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[1].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[1].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that no restaurants are retrieved when given an invalid area name.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantsByAreaWhenAreaInvalid() throws Exception {
        mockMvc.perform(get("/restaurant?area=Not A Valid Area")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid operation status of Open.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByOperationStatusWhenOperationStatusValidAndOpen() throws Exception {
        mockMvc.perform(get("/restaurant?operationstatus=Open")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid operation status of closed.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByOperationStatusWhenOperationStatusValidAndClosed() throws Exception {
        mockMvc.perform(get("/restaurant?operationstatus=Closed")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that no restaurants are retrieved when given an invalid operation status.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByOperationStatusWhenOperationStatusInvalid() throws Exception {
        mockMvc.perform(get("/restaurant?operationstatus=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid vegetarian availability
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByVegetarianAvailabilityWhenVegetarianAvailabilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/restaurant?servesvegetarian=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid vegetarian availability
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByVegetarianAvailabilityWhenVegetarianAvailabilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/restaurant?servesvegetarian=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that the correct restaurants are retrieved when given a invalid vegetarian availability.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByVegetarianAvailabilityWhenVegetarianAvailabilityIsInvalid() throws Exception {
        mockMvc.perform(get("/restaurant?servesvegetarian=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid vegan availability
     * of false.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByVeganAvailabilityWhenVeganAvailabilityIsValidAndFalse() throws Exception {
        mockMvc.perform(get("/restaurant?servesvegan=false")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that the correct restaurants are retrieved when given a valid vegan availability
     * of true.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByVeganAvailabilityWhenVeganAvailabilityIsValidAndTrue() throws Exception {
        mockMvc.perform(get("/restaurant?servesvegan=true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)));
    }

    /**
     * Tests that the correct restaurants are retrieved when given a invalid vegan availability.
     * @throws Exception
     */
    @Test
    public void testGetRestaurantByVeganAvailabilityWhenVeganAvailabilityIsInvalid() throws Exception {
        mockMvc.perform(get("/restaurant?servesvegan=Not Valid")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests that the correct restaurants are retrieved when all restaurants are requested.
     * @throws Exception
     */
    @Test
    public void testGetAllRestaurants() throws Exception {
        mockMvc.perform(get("/restaurant")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].restaurantName", Matchers.is("Test Restaurant 1")))
                .andExpect(jsonPath("$[0].description", Matchers.is("Test Description 1")))
                .andExpect(jsonPath("$[0].parkName", Matchers.is("Test Park 1")))
                .andExpect(jsonPath("$[0].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[0].operationStatus", Matchers.is("Open")))
                .andExpect(jsonPath("$[0].openingTime", Matchers.is("08:00:00")))
                .andExpect(jsonPath("$[0].closingTime", Matchers.is("22:00:00")))
                .andExpect(jsonPath("$[0].servesVegetarian", Matchers.is(false)))
                .andExpect(jsonPath("$[0].servesVegan", Matchers.is(false)))
                .andExpect(jsonPath("$[0].*", Matchers.hasSize(9)))
                .andExpect(jsonPath("$[1].restaurantName", Matchers.is("Test Restaurant 2")))
                .andExpect(jsonPath("$[1].description", Matchers.is("Test Description 2")))
                .andExpect(jsonPath("$[1].parkName", Matchers.is("Test Park 2")))
                .andExpect(jsonPath("$[1].area", Matchers.is("Test Area")))
                .andExpect(jsonPath("$[1].operationStatus", Matchers.is("Closed")))
                .andExpect(jsonPath("$[1].openingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].closingTime", Matchers.nullValue()))
                .andExpect(jsonPath("$[1].servesVegetarian", Matchers.is(true)))
                .andExpect(jsonPath("$[1].servesVegan", Matchers.is(true)))
                .andExpect(jsonPath("$[1].*", Matchers.hasSize(9)));
    }

}
