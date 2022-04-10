package E02VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;


    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }



    public void setFuelConsumption(double subtraction) {
        this.fuelConsumption -= subtraction;
    }


    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() +
                    " needs refueling";
        }
        this.fuelQuantity -= fuelNeeded;
        return String.format("%s travelled " + new DecimalFormat("#.##").format(distance) + " km",
                this.getClass().getSimpleName(), distance);
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }



    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
