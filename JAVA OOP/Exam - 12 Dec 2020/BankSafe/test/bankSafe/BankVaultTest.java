package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {

    private BankVault bankVault;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
    }

    @Test
    public void testGetVaultCells() {
        Map<String, Item> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A1", null);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", null);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);
        Map<String, Item> actualMap = this.bankVault.getVaultCells();
        Assert.assertEquals(expectedMap, actualMap);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCellDoesNotExistThrowIAE() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        this.bankVault.addItem("D1", item);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfItemAlreadyInCellThrowONSE() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        this.bankVault.addItem("C2", item);
        this.bankVault.addItem("C2", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCellIsAlreadyTakenThrowIAE() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        Item item2 = new Item("Gosho", "2");
        this.bankVault.addItem("D1", item);
        this.bankVault.addItem("D1", item2);
    }

    @Test
    public void addItemToCellShouldWork() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        String expected = "Item:1 saved successfully!";
        String actual = this.bankVault.addItem("C2", item);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenRemoveIfCellDoesNotExistThrowIAE() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        this.bankVault.removeItem("D1", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenRemoveIfItemInCellDoesNotExistThrowIAE() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        this.bankVault.removeItem("C1", item);
    }

    @Test
    public void removeItemShouldWork() throws OperationNotSupportedException {
        Item item = new Item("Pesho", "1");
        this.bankVault.addItem("C2", item);
        String expected = "Remove item:1 successfully!";
        String actual = this.bankVault.removeItem("C2", item);
        Assert.assertEquals(expected, actual);
        Assert.assertNull(bankVault.getVaultCells().get("C2"));
    }
}