package com.jamesmhare.viewthequeue.model.restaurant;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Serves as a test class for the {@link Restaurant.Builder}.
 */
public class TestRestaurantBuilder {

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given name.
     */
    @Test
    public void testRestaurantBuilderWithNameGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withName("Test Restaurant Name").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getRestaurantName(), "Test Restaurant Name");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given description.
     */
    @Test
    public void testRestaurantBuilderWithDescriptionGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withDescription("Test Restaurant Description").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getDescription(), "Test Restaurant Description");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given Theme Park.
     */
    @Test
    public void testRestaurantBuilderWithThemeParkNameGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withParkName("Test Restaurant Theme Park").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getParkName(), "Test Restaurant Theme Park");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given area.
     */
    @Test
    public void testRestaurantBuilderWithAreaGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withArea("Test Restaurant Area").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getArea(), "Test Restaurant Area");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given operation status.
     */
    @Test
    public void testRestaurantBuilderWithOperationStatusGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withOperationStatus("Test Operation Status").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getOperationStatus(), "Test Operation Status");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given opening time.
     */
    @Test
    public void testRestaurantBuilderWithOpeningTimeGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withOpeningTime("Test Opening Time").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getOpeningTime(), "Test Opening Time");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with a given closing time.
     */
    @Test
    public void testRestaurantBuilderWithClosingTimeGiven() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .withClosingTime("Test Closing Time").build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getClosingTime(), "Test Closing Time");
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with vegetarian availability.
     */
    @Test
    public void testRestaurantBuilderWithVegetarianAvailability() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .servesVegetarian(true).build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.isServesVegetarian(), true);
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant without vegetarian availability.
     */
    @Test
    public void testRestaurantBuilderWithoutVegetarianAvailability() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .servesVegetarian(false).build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.isServesVegetarian(), false);
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with vegan availability.
     */
    @Test
    public void testRestaurantBuilderWithVeganAvailability() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .servesVegan(true).build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.isServesVegan(), true);
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant without vegan availability.
     */
    @Test
    public void testRestaurantBuilderWithoutVeganAvailability() {
        Restaurant testRestaurant = new Restaurant.Builder()
                .servesVegan(false).build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.isServesVegan(), false);
    }

    /**
     * Tests that the {@link Restaurant.Builder} creates a Restaurant with no attributes given.
     */
    @Test
    public void testRestaurantBuilderWithNoAttributesGiven() {
        Restaurant testRestaurant = new Restaurant.Builder().build();
        assertThat(testRestaurant, instanceOf(Restaurant.class));
        assertEquals(testRestaurant.getRestaurantName(), null);
        assertEquals(testRestaurant.getDescription(), null);
        assertEquals(testRestaurant.getParkName(), null);
        assertEquals(testRestaurant.getArea(), null);
        assertEquals(testRestaurant.getOperationStatus(), null);
        assertEquals(testRestaurant.getOpeningTime(), null);
        assertEquals(testRestaurant.getClosingTime(), null);
        assertEquals(testRestaurant.isServesVegetarian(), false);
        assertEquals(testRestaurant.isServesVegan(), false);
    }

}
