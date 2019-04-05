package com.jamesmhare.viewthequeue.model.themepark;

import com.jamesmhare.viewthequeue.model.attraction.Attraction;
import com.jamesmhare.viewthequeue.model.restaurant.Restaurant;
import com.jamesmhare.viewthequeue.model.show.Show;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Serves as a test class for the {@link ThemePark.Builder}.
 */
public class TestThemeParkBuilder {

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given name.
     */
    @Test
    public void testThemeParkBuilderWithNameGiven() {
        ThemePark testThemePark = new ThemePark.Builder()
                .withName("Test Park Name").build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertEquals(testThemePark.getParkName(), "Test Park Name");
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given description.
     */
    @Test
    public void testThemeParkBuilderWithDescriptionGiven() {
        ThemePark testThemePark = new ThemePark.Builder()
                .withDescription("Test Park Description").build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertEquals(testThemePark.getDescription(), "Test Park Description");
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given operation status.
     */
    @Test
    public void testThemeParkWithOperationStatusGiven() {
        ThemePark testThemePark = new ThemePark.Builder()
                .withOperationStatus("Test Operation Status").build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertEquals(testThemePark.getOperationStatus(), "Test Operation Status");
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given opening time.
     */
    @Test
    public void testThemeParkBuilderWithOpeningTimeGiven() {
        ThemePark testThemePark = new ThemePark.Builder()
                .withOpeningTime("Test Opening Time").build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertEquals(testThemePark.getOpeningTime(), "Test Opening Time");
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given closing time.
     */
    @Test
    public void testThemeParkBuilderWithClosingTimeGiven() {
        ThemePark testThemePark = new ThemePark.Builder()
                .withClosingTime("Test Closing Time").build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertEquals(testThemePark.getClosingTime(), "Test Closing Time");
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given list of attractions.
     */
    @Test
    public void testThemeParkBuilderWithAttractionsGiven() {
        List<Attraction> testAttractions = new ArrayList<>();
        testAttractions.add(new Attraction.Builder()
                .withName("Test Attraction 1")
                .withDescription("Test Description 1")
                .withParkName("Test Theme Park 1")
                .withArea("Test Attraction Area 1")
                .withOperationStatus("Test Operation Status 1")
                .withOpeningTime("Test Opening Time 1")
                .withClosingTime("Test Closing Time 1")
                .withWaitTime(10)
                .withMaxHeightRestrictionInInches(10)
                .withMinHeightRestrictionInInches(10)
                .withWheelchairAccessibility(true)
                .withExpressLine(true)
                .withSingleRiderLine(true)
                .build());
        testAttractions.add(new Attraction.Builder()
                .withName("Test Attraction 2")
                .withDescription("Test Description 2")
                .withParkName("Test Theme Park 2")
                .withArea("Test Attraction Area 2")
                .withOperationStatus("Test Operation Status 2")
                .withOpeningTime("Test Opening Time 2")
                .withClosingTime("Test Closing Time 2")
                .withWaitTime(20)
                .withMaxHeightRestrictionInInches(20)
                .withMinHeightRestrictionInInches(20)
                .withWheelchairAccessibility(false)
                .withExpressLine(false)
                .withSingleRiderLine(false)
                .build());
        ThemePark testThemePark = new ThemePark.Builder()
                .withAttractions(testAttractions).build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertThat(testThemePark.getAttractions(), instanceOf(List.class));
        assertEquals(testThemePark.getAttractions().size(), 2);
        assertEquals(testThemePark.getAttractions().get(0).getAttractionName(), "Test Attraction 1");
        assertEquals(testThemePark.getAttractions().get(0).getDescription(), "Test Description 1");
        assertEquals(testThemePark.getAttractions().get(0).getParkName(), "Test Theme Park 1");
        assertEquals(testThemePark.getAttractions().get(0).getArea(), "Test Attraction Area 1");
        assertEquals(testThemePark.getAttractions().get(0).getOperationStatus(), "Test Operation Status 1");
        assertEquals(testThemePark.getAttractions().get(0).getOpeningTime(), "Test Opening Time 1");
        assertEquals(testThemePark.getAttractions().get(0).getClosingTime(), "Test Closing Time 1");
        assertEquals(testThemePark.getAttractions().get(0).getWaitTime(), 10);
        assertEquals(testThemePark.getAttractions().get(0).getMaxHeightRestrictionInches(), 10);
        assertEquals(testThemePark.getAttractions().get(0).getMinHeightRestrictionInches(), 10);
        assertEquals(testThemePark.getAttractions().get(0).isWheelchairAccessible(), true);
        assertEquals(testThemePark.getAttractions().get(0).isExpressLine(), true);
        assertEquals(testThemePark.getAttractions().get(0).isSingleRider(), true);
        assertEquals(testThemePark.getAttractions().get(1).getAttractionName(), "Test Attraction 2");
        assertEquals(testThemePark.getAttractions().get(1).getDescription(), "Test Description 2");
        assertEquals(testThemePark.getAttractions().get(1).getParkName(), "Test Theme Park 2");
        assertEquals(testThemePark.getAttractions().get(1).getArea(), "Test Attraction Area 2");
        assertEquals(testThemePark.getAttractions().get(1).getOperationStatus(), "Test Operation Status 2");
        assertEquals(testThemePark.getAttractions().get(1).getOpeningTime(), "Test Opening Time 2");
        assertEquals(testThemePark.getAttractions().get(1).getClosingTime(), "Test Closing Time 2");
        assertEquals(testThemePark.getAttractions().get(1).getWaitTime(), 20);
        assertEquals(testThemePark.getAttractions().get(1).getMaxHeightRestrictionInches(), 20);
        assertEquals(testThemePark.getAttractions().get(1).getMinHeightRestrictionInches(), 20);
        assertEquals(testThemePark.getAttractions().get(1).isWheelchairAccessible(), false);
        assertEquals(testThemePark.getAttractions().get(1).isExpressLine(), false);
        assertEquals(testThemePark.getAttractions().get(1).isSingleRider(), false);
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given list of attractions
     * that is empty.
     */
    @Test
    public void testThemeParkBuilderWhenAttractionsGivenIsEmpty() {
        List<Attraction> testAttractions = new ArrayList<>();
        ThemePark testThemePark = new ThemePark.Builder()
                .withAttractions(testAttractions).build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertThat(testThemePark.getAttractions(), instanceOf(List.class));
        assertTrue(testThemePark.getAttractions().isEmpty());
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given list of shows.
     */
    @Test
    public void testThemeParkBuilderWithShowsGiven() {
        List<Show> testShows = new ArrayList<>();
        testShows.add(new Show.Builder()
                .withName("Test Show 1")
                .withDescription("Test Description 1")
                .withParkName("Test Show Theme Park 1")
                .withArea("Test Show Area 1")
                .withOperationStatus("Test Operation Status 1")
                .withWheelchairAccessibility(true)
                .withExpressLine(true)
                .withShowTimes("10:00, 14:30, 17:00")
                .build());
        testShows.add(new Show.Builder()
                .withName("Test Show 2")
                .withDescription("Test Description 2")
                .withParkName("Test Show Theme Park 2")
                .withArea("Test Show Area 2")
                .withOperationStatus("Test Operation Status 2")
                .withWheelchairAccessibility(false)
                .withExpressLine(false)
                .withShowTimes("11:30, 15:00, 18:30")
                .build());
        ThemePark testThemePark = new ThemePark.Builder()
                .withShows(testShows).build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertThat(testThemePark.getShows(), instanceOf(List.class));
        assertEquals(testThemePark.getShows().size(), 2);
        assertEquals(testThemePark.getShows().get(0).getShowName(), "Test Show 1");
        assertEquals(testThemePark.getShows().get(0).getDescription(), "Test Description 1");
        assertEquals(testThemePark.getShows().get(0).getParkName(), "Test Show Theme Park 1");
        assertEquals(testThemePark.getShows().get(0).getArea(), "Test Show Area 1");
        assertEquals(testThemePark.getShows().get(0).getOperationStatus(), "Test Operation Status 1");
        assertEquals(testThemePark.getShows().get(0).isWheelchairAccessible(), true);
        assertEquals(testThemePark.getShows().get(0).isExpressLine(), true);
        assertEquals(testThemePark.getShows().get(0).getShowTimes(), "10:00, 14:30, 17:00");
        assertEquals(testThemePark.getShows().get(1).getShowName(), "Test Show 2");
        assertEquals(testThemePark.getShows().get(1).getDescription(), "Test Description 2");
        assertEquals(testThemePark.getShows().get(1).getParkName(), "Test Show Theme Park 2");
        assertEquals(testThemePark.getShows().get(1).getArea(), "Test Show Area 2");
        assertEquals(testThemePark.getShows().get(1).getOperationStatus(), "Test Operation Status 2");
        assertEquals(testThemePark.getShows().get(1).isWheelchairAccessible(), false);
        assertEquals(testThemePark.getShows().get(1).isExpressLine(), false);
        assertEquals(testThemePark.getShows().get(1).getShowTimes(), "11:30, 15:00, 18:30");

    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given list of shows
     * that is empty.
     */
    @Test
    public void testThemeParkBuilderWhenShowsGivenIsEmpty() {
        List<Show> testShows = new ArrayList<>();
        ThemePark testThemePark = new ThemePark.Builder()
                .withShows(testShows).build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertThat(testThemePark.getShows(), instanceOf(List.class));
        assertTrue(testThemePark.getShows().isEmpty());
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given list of restaurants.
     */
    @Test
    public void testThemeParkBuilderWithRestaurantsGiven() {
        List<Restaurant> testRestaurants = new ArrayList<>();
        testRestaurants.add(new Restaurant.Builder()
                .withName("Test Restaurant 1")
                .withDescription("Test Restaurant Description 1")
                .withParkName("Test Restaurant Theme Park 1")
                .withArea("Test Restaurant Area 1")
                .withOperationStatus("Test Operation Status 1")
                .withOpeningTime("Test Opening Time 1")
                .withClosingTime("Test Closing Time 1")
                .servesVegetarian(true)
                .servesVegan(true)
                .build());
        testRestaurants.add(new Restaurant.Builder()
                .withName("Test Restaurant 2")
                .withDescription("Test Restaurant Description 2")
                .withParkName("Test Restaurant Theme Park 2")
                .withArea("Test Restaurant Area 2")
                .withOperationStatus("Test Operation Status 2")
                .withOpeningTime("Test Opening Time 2")
                .withClosingTime("Test Closing Time 2")
                .servesVegetarian(false)
                .servesVegan(false)
                .build());
        ThemePark testThemePark = new ThemePark.Builder()
                .withRestaurants(testRestaurants).build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertThat(testThemePark.getRestaurants(), instanceOf(List.class));
        assertEquals(testThemePark.getRestaurants().size(), 2);
        assertEquals(testThemePark.getRestaurants().get(0).getRestaurantName(), "Test Restaurant 1");
        assertEquals(testThemePark.getRestaurants().get(0).getDescription(), "Test Restaurant Description 1");
        assertEquals(testThemePark.getRestaurants().get(0).getParkName(), "Test Restaurant Theme Park 1");
        assertEquals(testThemePark.getRestaurants().get(0).getArea(), "Test Restaurant Area 1");
        assertEquals(testThemePark.getRestaurants().get(0).getOperationStatus(), "Test Operation Status 1");
        assertEquals(testThemePark.getRestaurants().get(0).getOpeningTime(), "Test Opening Time 1");
        assertEquals(testThemePark.getRestaurants().get(0).getClosingTime(), "Test Closing Time 1");
        assertEquals(testThemePark.getRestaurants().get(0).isServesVegetarian(), true);
        assertEquals(testThemePark.getRestaurants().get(0).isServesVegan(), true);
        assertEquals(testThemePark.getRestaurants().get(1).getRestaurantName(), "Test Restaurant 2");
        assertEquals(testThemePark.getRestaurants().get(1).getDescription(), "Test Restaurant Description 2");
        assertEquals(testThemePark.getRestaurants().get(1).getParkName(), "Test Restaurant Theme Park 2");
        assertEquals(testThemePark.getRestaurants().get(1).getArea(), "Test Restaurant Area 2");
        assertEquals(testThemePark.getRestaurants().get(1).getOperationStatus(), "Test Operation Status 2");
        assertEquals(testThemePark.getRestaurants().get(1).getOpeningTime(), "Test Opening Time 2");
        assertEquals(testThemePark.getRestaurants().get(1).getClosingTime(), "Test Closing Time 2");
        assertEquals(testThemePark.getRestaurants().get(1).isServesVegetarian(), false);
        assertEquals(testThemePark.getRestaurants().get(1).isServesVegan(), false);
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with a given list of restaurants
     * that is empty.
     */
    @Test
    public void testThemeParkBuilderWhenRestaurantsGivenIsEmpty() {
        List<Restaurant> testRestaurants = new ArrayList<>();
        ThemePark testThemePark = new ThemePark.Builder()
                .withRestaurants(testRestaurants).build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertThat(testThemePark.getRestaurants(), instanceOf(List.class));
        assertTrue(testThemePark.getRestaurants().isEmpty());
    }

    /**
     * Tests that the {@link ThemePark.Builder} creates a Theme Park with no attributes given.
     */
    @Test
    public void testThemeParkBuilderWithNoAttributesGiven() {
        ThemePark testThemePark = new ThemePark.Builder().build();
        assertThat(testThemePark, instanceOf(ThemePark.class));
        assertEquals(testThemePark.getParkName(), null);
        assertEquals(testThemePark.getDescription(), null);
        assertEquals(testThemePark.getOperationStatus(), null);
        assertEquals(testThemePark.getOpeningTime(), null);
        assertEquals(testThemePark.getClosingTime(), null);
        assertEquals(testThemePark.getAttractions(), null);
        assertEquals(testThemePark.getShows(), null);
        assertEquals(testThemePark.getRestaurants(), null);
    }
}
