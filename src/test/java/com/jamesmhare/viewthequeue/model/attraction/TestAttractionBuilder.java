package com.jamesmhare.viewthequeue.model.attraction;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Serves as a test class for the {@link Attraction.Builder}.
 */
public class TestAttractionBuilder {

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given name.
     */
    @Test
    public void testAttractionBuilderWithNameGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withName("Test Attraction Name").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getAttractionName(), "Test Attraction Name");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given description.
     */
    @Test
    public void testAttractionBuilderWithDescriptionGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withDescription("Test Attraction Description").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getDescription(), "Test Attraction Description");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given Theme Park.
     */
    @Test
    public void testAttractionBuilderWithThemeParkNameGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withParkName("Test Attraction Theme Park").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getParkName(), "Test Attraction Theme Park");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given area.
     */
    @Test
    public void testAttractionBuilderWithAreaGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withArea("Test Attraction Area").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getArea(), "Test Attraction Area");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given operation status.
     */
    @Test
    public void testAttractionBuilderWithOperationStatusGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withOperationStatus("Test Operation Status").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getOperationStatus(), "Test Operation Status");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given opening time.
     */
    @Test
    public void testAttractionBuilderWithOpeningTimeGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withOpeningTime("Test Opening Time").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getOpeningTime(), "Test Opening Time");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given closing time.
     */
    @Test
    public void testAttractionBuilderWithClosingTimeGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withClosingTime("Test Closing Time").build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getClosingTime(), "Test Closing Time");
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given wait time.
     */
    @Test
    public void testAttractionBuilderWithWaitTimeGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withWaitTime(20).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getWaitTime(), 20);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given max height in inches.
     */
    @Test
    public void testAttractionBuilderWithMaxHeightGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withMaxHeightRestrictionInInches(60).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getMaxHeightRestrictionInches(), 60);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with a given min height in inches.
     */
    @Test
    public void testAttractionBuilderWithMinHeightGiven() {
        Attraction testAttraction = new Attraction.Builder()
                .withMinHeightRestrictionInInches(40).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getMinHeightRestrictionInches(), 40);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with wheelchair access.
     */
    @Test
    public void testAttractionBuilderWithWheelchairAccess() {
        Attraction testAttraction = new Attraction.Builder()
                .withWheelchairAccessibility(true).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.isWheelchairAccessible(), true);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction without wheelchair access.
     */
    @Test
    public void testAttractionBuilderWithoutWheelchairAccess() {
        Attraction testAttraction = new Attraction.Builder()
                .withWheelchairAccessibility(false).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.isWheelchairAccessible(), false);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with express line.
     */
    @Test
    public void testAttractionBuilderWithExpressLine() {
        Attraction testAttraction = new Attraction.Builder()
                .withExpressLine(true).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.isExpressLine(), true);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction without express line.
     */
    @Test
    public void testAttractionBuilderWithoutExpressLine() {
        Attraction testAttraction = new Attraction.Builder()
                .withExpressLine(false).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.isExpressLine(), false);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with single rider line.
     */
    @Test
    public void testAttractionBuilderWithSingleRiderLine() {
        Attraction testAttraction = new Attraction.Builder()
                .withSingleRiderLine(true).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.isSingleRider(), true);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction without single rider line.
     */
    @Test
    public void testAttractionBuilderWithoutSingleRiderLine() {
        Attraction testAttraction = new Attraction.Builder()
                .withSingleRiderLine(false).build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.isSingleRider(), false);
    }

    /**
     * Tests that the {@link Attraction.Builder} creates an Attraction with no attributes given.
     */
    @Test
    public void testAttractionBuilderWithNoAttributesGiven() {
        Attraction testAttraction = new Attraction.Builder().build();
        assertThat(testAttraction, instanceOf(Attraction.class));
        assertEquals(testAttraction.getAttractionName(), null);
        assertEquals(testAttraction.getDescription(), null);
        assertEquals(testAttraction.getParkName(), null);
        assertEquals(testAttraction.getArea(), null);
        assertEquals(testAttraction.getOperationStatus(), null);
        assertEquals(testAttraction.getOpeningTime(), null);
        assertEquals(testAttraction.getClosingTime(), null);
        assertEquals(testAttraction.getWaitTime(), 0);
        assertEquals(testAttraction.getMaxHeightRestrictionInches(), 0);
        assertEquals(testAttraction.getMinHeightRestrictionInches(), 0);
        assertEquals(testAttraction.isWheelchairAccessible(), false);
        assertEquals(testAttraction.isExpressLine(), false);
        assertEquals(testAttraction.isSingleRider(), false);
    }

}
