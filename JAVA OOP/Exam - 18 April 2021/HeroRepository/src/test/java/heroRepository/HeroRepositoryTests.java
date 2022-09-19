package heroRepository;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;
    private Hero hero2;


    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Pesho", 5);
        this.hero2 = new Hero("Gosho", 10);
    }

    @Test(expected = NullPointerException.class)
    public void test1() {
        this.heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        this.heroRepository.create(hero);
        this.heroRepository.create(hero);
    }

    @Test
    public void test3() {
        this.heroRepository.create(hero);
        Assert.assertEquals("Pesho", hero.getName());
    }

    @Test(expected = NullPointerException.class)
    public void test4() {
        this.heroRepository.create(hero);
        this.heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void test5() {
        this.heroRepository.create(hero);
        this.heroRepository.remove(" ");
    }

    @Test
    public void test6() {
        this.heroRepository.create(hero);
        Assert.assertTrue(this.heroRepository.remove("Pesho"));
    }

    @Test
    public void test7() {
        this.heroRepository.create(hero);
        this.heroRepository.create(hero2);
        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void test8() {
        this.heroRepository.create(hero);
        Assert.assertEquals(hero, this.heroRepository.getHero("Pesho"));
    }

}
