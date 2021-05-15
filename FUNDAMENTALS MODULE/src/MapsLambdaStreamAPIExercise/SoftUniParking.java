package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> car = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scan.nextLine().split("\\s+");
            String option = input[0];

            switch (option) {
                case "register":

                    String name = input[1];
                    String plateNumber = input[2];

                    if (!car.containsKey(name)) {
                        car.put(name, plateNumber);
                        System.out.printf("%s registered %s successfully%n", name, car.get(name));
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", car.get(name));
                    }
                    break;
                case "unregister":

                    name = input[1];

                    if (car.containsKey(name)) {
                        car.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", name);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : car.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());

        }
    }
}
