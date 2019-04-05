package com.jamesmhare.viewthequeue.model.show;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Serves as a test class for the {@link Show.Builder}.
 */
public class TestShowBuilder {

    /**
     * Tests that the {@link Show.Builder} creates a Show with a given name.
     */
    @Test
    public void testShowBuilderWithNameGiven() {
        Show testShow = new Show.Builder()
                .withName("Test Show Name").build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getShowName(), "Test Show Name");
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with a given description.
     */
    @Test
    public void testShowBuilderWithDescriptionGiven() {
        Show testShow = new Show.Builder()
                .withDescription("Test Show Description").build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getDescription(), "Test Show Description");
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with a given Theme Park.
     */
    @Test
    public void testShowBuilderWithThemeParkNameGiven() {
        Show testShow = new Show.Builder()
                .withParkName("Test Show Theme Park").build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getParkName(), "Test Show Theme Park");
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with a given area.
     */
    @Test
    public void testShowBuilderWithAreaGiven() {
        Show testShow = new Show.Builder()
                .withArea("Test Show Area").build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getArea(), "Test Show Area");
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with a given operation status.
     */
    @Test
    public void testShowBuilderWithOperationStatusGiven() {
        Show testShow = new Show.Builder()
                .withOperationStatus("Test Operation Status").build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getOperationStatus(), "Test Operation Status");
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with wheelchair access.
     */
    @Test
    public void testShowBuilderWithWheelchairAccess() {
        Show testShow = new Show.Builder()
                .withWheelchairAccessibility(true).build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.isWheelchairAccessible(), true);
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show without wheelchair access.
     */
    @Test
    public void testShowBuilderWithoutWheelchairAccess() {
        Show testShow = new Show.Builder()
                .withWheelchairAccessibility(false).build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.isWheelchairAccessible(), false);
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with express line.
     */
    @Test
    public void testShowBuilderWithExpressLine() {
        Show testShow = new Show.Builder()
                .withExpressLine(true).build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.isExpressLine(), true);
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show without express line.
     */
    @Test
    public void testShowBuilderWithoutExpressLine() {
        Show testShow = new Show.Builder()
                .withExpressLine(false).build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.isExpressLine(), false);
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with given show times.
     */
    @Test
    public void testShowBuilderWithShowTimesGiven() {
        Show testShow = new Show.Builder()
                .withShowTimes("10:00, 14:30, 17:00").build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getShowTimes(), "10:00, 14:30, 17:00");
    }

    /**
     * Tests that the {@link Show.Builder} creates a Show with no attributes given.
     */
    @Test
    public void testShowBuilderWithNoAttributesGiven() {
        Show testShow = new Show.Builder().build();
        assertThat(testShow, instanceOf(Show.class));
        assertEquals(testShow.getShowName(), null);
        assertEquals(testShow.getDescription(), null);
        assertEquals(testShow.getParkName(), null);
        assertEquals(testShow.getArea(), null);
        assertEquals(testShow.getOperationStatus(), null);
        assertEquals(testShow.isWheelchairAccessible(), false);
        assertEquals(testShow.isExpressLine(), false);
        assertEquals(testShow.getShowTimes(), null);
    }

}
