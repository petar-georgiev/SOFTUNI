package E01Vehicles;

public class Car extends Vehicle {
    private static final double AIR_COND_CONS = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_COND_CONS);
    }

}
