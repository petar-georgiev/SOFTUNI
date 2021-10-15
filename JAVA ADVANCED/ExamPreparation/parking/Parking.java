package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity)
            this.data.add(car);
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car newCar = null;

        int latestYear = Integer.MIN_VALUE;
        for (Car car : this.data) {
            if (car.getYear() > latestYear) {
                latestYear = car.getYear();
            }
        }

        for (Car car : data) {
            if (car.getYear() == latestYear) {
                newCar = car;
            }
        }
        return newCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car newCar = null;

        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                newCar = car;
            }
        }
        return newCar;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The cars are parked in %s:%n", this.type));
        for (Car car : data) {
            sb.append(car + System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
