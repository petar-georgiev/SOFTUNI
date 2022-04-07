package E01Vehicles;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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
        this.fuelQuantity += liters;
    }


    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
