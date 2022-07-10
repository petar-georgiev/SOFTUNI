package bakery.entities.foodsImpl;

public class Cake extends BaseFood{
    public final static int INITIAL_CAKE_PORTION = 245;

    public Cake(String name, double price) {
        super(name, INITIAL_CAKE_PORTION, price);
    }

}
