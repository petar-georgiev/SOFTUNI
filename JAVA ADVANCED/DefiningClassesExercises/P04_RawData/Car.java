package DefiningClassesExercises.P04_RawData;

import java.util.Arrays;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public boolean isTireWithLessPressureThanOne() {
        for (Tire tire : tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isEnginePowerMoreThan(int value) {
        if (this.engine.getEnginePower() > value) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
