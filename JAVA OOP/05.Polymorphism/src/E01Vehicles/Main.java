package E01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        String[] carTokens = scan.nextLine().split("\\s+");
        String[] truckTokens = scan.nextLine().split("\\s+");
        vehicleMap.put("Car", new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2])));
        vehicleMap.put("Truck", new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2])));

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Drive":
                    System.out.println(vehicleMap.get(tokens[1]).drive(Double.parseDouble(tokens[2])));
                    break;
                case "Refuel":
                    vehicleMap.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                    break;
            }
        }
        for (Vehicle value : vehicleMap.values()) {
            System.out.println(value);
        }
    }
}
