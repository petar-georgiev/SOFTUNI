package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private ComputerManager cm;

    @Before
    public void setUp() {
        this.cm = new ComputerManager();
    }


    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        Computer computer = null;
        cm.addComputer(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
         Computer computer = new Computer("Hp", "z-45", 1500);
         Computer computer2 = new Computer("Hp", "z-45", 1500);
        cm.addComputer(computer);
        cm.addComputer(computer2);
    }

    @Test
    public void test3(){
        Computer computer = new Computer("Hp", "z-45", 1500);
        cm.addComputer(computer);
        Assert.assertEquals(computer,cm.removeComputer("Hp","z-45"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        Computer computer = null;
        cm.getComputer("Hp", "z-45");
    }

    @Test
    public void test5(){
        List<Computer> computers = new ArrayList<>();
        Computer computer = new Computer("Hp", "z-45", 1500);
        Computer computer2 = new Computer("Hp", "z-46", 1340);
        computers.add(computer);
        computers.add(computer2);
        cm.addComputer(computer);
        cm.addComputer(computer2);
        Assert.assertEquals(computers,cm.getComputersByManufacturer("Hp"));
    }

    @Test
    public void test6(){
        Computer computer = new Computer("Hp", "z-45", 1500);
        cm.addComputer(computer);
        Assert.assertEquals(1,cm.getCount());
    }

}