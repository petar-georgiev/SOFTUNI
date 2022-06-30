package bakery.entities.drinkImpl;

public class Water extends BaseDrink{
    public final static double WATER_PRICE = 1.50;


    public Water(String name, int portion, String brand) {
        super(name, portion, WATER_PRICE, brand);
    }
}
