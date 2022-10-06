package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {

    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("test_name", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Spaceship(" ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenBelowZero() {
        new Spaceship("Spaceship", -1);
    }

    @Test
    public void testGetAstronautsCountShouldReturnTwoWhenTwoAdded() {
        spaceship.add(new Astronaut("test_1", 100));
        spaceship.add(new Astronaut("test_2", 100));
        assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testGetAstronautsCountShouldReturnZeroWhenEmpty() {
        assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAstronautTwiceShouldFail() {
        spaceship.add(new Astronaut("test_1", 100));
        spaceship.add(new Astronaut("test_1", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsFullShouldFail() {
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        spaceship.add(new Astronaut("test_1", 100));
        spaceship.add(new Astronaut("test_2", 100));
    }
    @Test
    public void testRemoveAstronautShouldReturnFalseWhenNoSuchAdded() {
        spaceship.add(new Astronaut("test_1", 100));
       assertFalse(spaceship.remove("other"));
    }
    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded() {
        spaceship.add(new Astronaut("test_1", 100));
       assertTrue(spaceship.remove("test_1"));
    }
}
