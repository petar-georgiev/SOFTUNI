package bakery.entities.drinkImpl;

public class Tea extends BaseDrink{

    public final static double TEA_PRICE = 2.50;

    public Tea(String name, int portion, String brand) {
        super(name, portion, TEA_PRICE, brand);
    }
}
