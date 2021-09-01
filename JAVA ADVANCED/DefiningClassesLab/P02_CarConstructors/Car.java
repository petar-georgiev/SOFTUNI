package DefiningClassesLab.P02_CarConstructors;

public class Car {
    public String brand;
    public String model;
    public int horsePower;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand) {
        this(brand,"unknown",-1);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                brand, model, horsePower);
    }
}
