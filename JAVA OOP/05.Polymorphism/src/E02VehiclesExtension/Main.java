package E02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] carTokens = scan.nextLine().split("\\s+");
        String[] truckTokens = scan.nextLine().split("\\s+");
        String[] busTokens = scan.nextLine().split("\\s+");

        vehicleMap.put("Car", new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]),
                Double.parseDouble(carTokens[3])));
        vehicleMap.put("Truck", new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]),
                Double.parseDouble(carTokens[3])));
        vehicleMap.put("Bus", new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]),
                Double.parseDouble(busTokens[3])));

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            try {
                String[] tokens = scan.nextLine().split("\\s+");

                switch (tokens[0]) {
                    case "Drive":
                        System.out.println(vehicleMap.get(tokens[1]).drive(Double.parseDouble(tokens[2])));
                        break;
                    case "DriveEmpty":
                        System.out.println(((Bus) vehicleMap.get(tokens[1]))
                                .driveWithPassengers(Double.parseDouble(tokens[2])));
                        break;
                    case "Refuel":
                        vehicleMap.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                        break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (Vehicle value : vehicleMap.values()) {
            System.out.println(value);
        }
    }
}
