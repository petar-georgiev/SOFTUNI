package bakery.entities.foodsImpl;

public class Bread extends BaseFood{
    public final static int INITIAL_BREAD_PORTION = 200;


    public Bread(String name, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }

}
