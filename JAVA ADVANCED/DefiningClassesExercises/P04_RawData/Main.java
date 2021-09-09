package DefiningClassesExercises.P04_RawData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Tire[] tire = new Tire[4];
            int counter = 0;

            for (int i = 4; i < tokens.length - 1; i += 2) {
                double tirePressure = Double.parseDouble(tokens[i + 1]);
                int tireAge = Integer.parseInt(tokens[i + 2]);
                tire[counter++] = new Tire(tirePressure, tireAge);
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model, engine, cargo, tire);
            cars.put(model, car);


        }
        String option = scan.nextLine();
        if (option.equals("fragile")) {
            cars.entrySet().stream()
                    .filter(f -> f.getValue().getCargo().getType().equals(option))
                    .filter(p -> p.getValue().isTireWithLessPressureThanOne())
                    .forEach(s -> System.out.println(s.getValue()));

        } else if (option.equals("flamable")) {
            cars.entrySet().stream()
                    .filter(f -> f.getValue().getCargo().getType().equals(option))
                    .filter(p -> p.getValue().isEnginePowerMoreThan(250))
                    .forEach(s -> System.out.println(s.getValue()));
        }

    }
}
