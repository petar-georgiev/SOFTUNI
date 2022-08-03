package restaurant.entities.tables;

public class Indoors extends BaseTable{
    private static final double CONSTANT_PRICE = 3.50;
    public Indoors(int number, int size) {
        super(number, size, CONSTANT_PRICE);
    }
}
