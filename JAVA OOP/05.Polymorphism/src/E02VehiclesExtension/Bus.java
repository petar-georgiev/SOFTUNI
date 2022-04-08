package E02VehiclesExtension;


public class Bus extends Vehicle {
    private static final double AIR_COND_CONS = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_COND_CONS, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        setFuelConsumption(AIR_COND_CONS);
        return super.drive(distance);
    }
}