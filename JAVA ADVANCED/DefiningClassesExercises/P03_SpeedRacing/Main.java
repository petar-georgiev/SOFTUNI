package DefiningClassesExercises.P03_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, consumption);
            cars.put(model, car);
        }
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String model = input.split("\\s+")[1];
            int distanceToDrive = Integer.parseInt(input.split("\\s+")[2]);

            Car carToDrive = cars.get(model);
            if (!carToDrive.drive(distanceToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }


            input = scan.nextLine();
        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
