package E01Vehicles;

public class Truck extends Vehicle {
    private static final double AIR_COND_CONS = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_COND_CONS);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
