package FinalExams;

import java.security.KeyStore;
import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> cityMap = new LinkedHashMap<>();


        String input = scan.nextLine();


        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");

            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (cityMap.containsKey(city)) {
                cityMap.get(city).set(0, cityMap.get(city).get(0) + population);
                cityMap.get(city).set(1, cityMap.get(city).get(1) + gold);
            } else {
                cityMap.putIfAbsent(city, new LinkedList<>());
                cityMap.get(city).add(population);
                cityMap.get(city).add(gold);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens2 = input.split("=>");
            if (tokens2[0].equals("Plunder")) {
                String city = tokens2[1];
                int people = Integer.parseInt(tokens2[2]);
                int gold = Integer.parseInt(tokens2[3]);

                cityMap.get(city).set(0, cityMap.get(city).get(0) - people);
                cityMap.get(city).set(1, cityMap.get(city).get(1) - gold);

                System.out.printf("%s plundered! %d gold stolen, " +
                        "%d citizens killed.%n", city, gold, people);
                if (cityMap.get(city).get(0) <= 0 || cityMap.get(city).get(1) <= 0) {
                    cityMap.remove(city);
                    System.out.printf("%s has been wiped off the map!%n", city);
                }

            } else {
                String city = tokens2[1];
                int gold = Integer.parseInt(tokens2[2]);

                if (gold > 0) {
                    cityMap.get(city).set(1, cityMap.get(city).get(1) + gold);
                    System.out.printf("%d gold added to the city treasury." +
                            " %s now has %d gold.%n", gold, city, cityMap.get(city).get(1));
                } else
                    System.out.println("Gold added cannot be a negative number!");

            }

            input = scan.nextLine();

        }

        System.out.printf("Ahoy, Captain! " +
                "There are %d wealthy settlements to go to:%n", cityMap.size());


        cityMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue
                        ((s1, s2) -> s2.get(1).compareTo(s1.get(1))))
                .forEach(p -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        p.getKey(), p.getValue().get(0), p.getValue().get(1)));
    }
}
