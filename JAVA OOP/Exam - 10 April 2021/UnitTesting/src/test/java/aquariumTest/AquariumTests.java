package aquariumTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameToNullThrowNPE() {
        new Aquarium(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameToEmptyThrowNPE() {
        new Aquarium(" ", 3);
    }

    @Test
    public void testSetNameShouldSetCorrectName() {
        Aquarium aquarium = new Aquarium("AquariumName", 3);
        assertEquals("AquariumName", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityIsLessThanZeroThrowIAE() {
        new Aquarium("Aqua", -1);
    }

    @Test
    public void testSetCapacityShouldSetCorrectCapacity() {
        Aquarium aquarium = new Aquarium("AquariumName", 1);
        assertEquals(1, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityEqualsToSizeThrowIAE() {
        Aquarium aquarium = new Aquarium("Aqua", 1);
        Fish fish = new Fish("Zlatna Ribka");
        Fish fish2 = new Fish("Zlatna Ribka2");
        aquarium.add(fish);
        aquarium.add(fish2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFishDoesNotExistThrowIAE() {
        Aquarium aquarium = new Aquarium("Aqua", 1);
        aquarium.remove("Pesho Ribata");
    }

    @Test
    public void testSetAvailableToFalse() {
        Aquarium aquarium = new Aquarium("Aqua", 1);
        Fish fish = new Fish("Zlatna Ribka");
        aquarium.add(fish);
        aquarium.sellFish("Zlatna Ribka");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testGetReportOfAvailableFish() {
        Aquarium aquarium = new Aquarium("Aqua", 1);
        Fish fish = new Fish("Zlatna Ribka");
        aquarium.add(fish);
        String actual = aquarium.report();
        String expected = "Fish available at Aqua: Zlatna Ribka";
        assertEquals(expected, actual);
    }

}
