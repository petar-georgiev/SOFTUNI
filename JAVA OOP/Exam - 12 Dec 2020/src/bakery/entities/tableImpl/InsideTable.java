package bakery.entities.tableImpl;

public class InsideTable extends BaseTable {
    public final static double PRICE_PER_PERSON = 2.50;

    public InsideTable(int tableNumber, int capacity){
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
