package FinalExams;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Integer>> carMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scan.nextLine().split("\\|");
            String car = carInfo[0];
            Integer mileage = Integer.parseInt(carInfo[1]);
            Integer fuel = Integer.parseInt(carInfo[2]);

            carMap.putIfAbsent(car, new LinkedList<>());
            carMap.get(car).add(mileage);
            carMap.get(car).add(fuel);
        }
        String input = scan.nextLine();

        while (!input.equals("Stop")) {

            String[] tokens = input.split(" : ");
            String carName = tokens[1];

            Integer mileageMap = carMap.get(carName).get(0);
            Integer fuelMap = carMap.get(carName).get(1);

            switch (tokens[0]) {
                case "Drive":
                    Integer distance = Integer.parseInt(tokens[2]);
                    Integer fuel = Integer.parseInt(tokens[3]);
                    if (fuelMap >= fuel) {
                        carMap.get(carName).set(0, mileageMap + distance);
                        carMap.get(carName).set(1, fuelMap - fuel);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                carName, distance, fuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (carMap.get(carName).get(0) >= 100000) {
                        carMap.remove(carName);
                        System.out.printf("Time to sell the %s!%n", carName);
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(tokens[2]);

                    if (fuelMap + fuel > 75) {
                        carMap.get(carName).set(1, 75);
                        System.out.printf("%s refueled with %d liters%n",
                                carName, 75 - fuelMap);
                    } else {
                        carMap.get(carName).set(1, fuelMap + fuel);
                        System.out.printf("%s refueled with %d liters%n",
                                carName, fuel);
                    }
                    break;
                case "Revert":
                    distance = Integer.parseInt(tokens[2]);
                    carMap.get(carName).set(0, mileageMap - distance);
                    if (carMap.get(carName).get(0) < 10000) {
                        carMap.get(carName).set(0, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n",
                                carName, distance);
                    }
                    break;
            }

            input = scan.nextLine();
        }

        carMap.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().get(0).compareTo(s1.getValue().get(0)))
                .forEach(s -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                        , s.getKey(), s.getValue().get(0), s.getValue().get(1)));
    }
}
