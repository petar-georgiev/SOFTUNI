package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test
    public void test0() {
        Map<String, Goods> expectedMap = new LinkedHashMap<>();
        expectedMap.put("Shelves1", null);
        expectedMap.put("Shelves2", null);
        expectedMap.put("Shelves3", null);
        expectedMap.put("Shelves4", null);
        expectedMap.put("Shelves5", null);
        expectedMap.put("Shelves6", null);
        expectedMap.put("Shelves7", null);
        expectedMap.put("Shelves8", null);
        expectedMap.put("Shelves9", null);
        expectedMap.put("Shelves10", null);
        expectedMap.put("Shelves11", null);
        expectedMap.put("Shelves12", null);
        Map<String, Goods> actualMap = this.shop.getShelves();
        Assert.assertEquals(expectedMap, actualMap);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() throws OperationNotSupportedException {
        Goods goods = new Goods("Apple", "1");
        this.shop.addGoods("Shelves13", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() throws OperationNotSupportedException {
        Goods goods = new Goods("Apple", "1");
        this.shop.addGoods("Shelves13", goods);
        this.shop.addGoods("Shelves13", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() throws OperationNotSupportedException {
        Goods goods = new Goods("Apple", "1");
        Goods goods2 = new Goods("Orange", "1");
        this.shop.addGoods("Shelves13", goods);
        this.shop.addGoods("Shelves13", goods2);
    }

    @Test
    public void test4() throws OperationNotSupportedException {
        Goods goods = new Goods("Apple", "1");
        String expected = "Goods: 1 is placed successfully!";
        String actual = this.shop.addGoods("Shelves12", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() throws OperationNotSupportedException {
        Goods good = new Goods("Apple", "1");
        this.shop.addGoods("Shelves12", good);
        this.shop.removeGoods("Shelves13", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() throws OperationNotSupportedException {
        Goods good = new Goods("Apple", "1");
        Goods good2 = new Goods("Apple", "1");
        this.shop.addGoods("Shelves12", good);
        this.shop.removeGoods("Shelves12", good2);
    }

    @Test
    public void test7() throws OperationNotSupportedException {
        Goods goods = new Goods("Apple", "1");
        this.shop.addGoods("Shelves12", goods);
        String expected = "Goods: 1 is removed successfully!";
        String actual = this.shop.removeGoods("Shelves12", goods);
        Assert.assertEquals(expected, actual);
        Assert.assertNull(shop.getShelves().get("Shelves12"));
    }


}