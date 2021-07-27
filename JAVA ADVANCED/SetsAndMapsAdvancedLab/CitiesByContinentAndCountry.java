package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, LinkedList<String>>> locationMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            locationMap.putIfAbsent(continent, new LinkedHashMap<>());
            locationMap.get(continent).putIfAbsent(country, new LinkedList<>());

            locationMap.get(continent).get(country).add(city);

        }
        locationMap.entrySet().stream()
                .forEach(s -> {
                    System.out.printf("%s:%n", s.getKey());
                    s.getValue().entrySet().stream().forEach(e -> {
                        System.out.printf("  %s -> ", e.getKey());
                        System.out.print(String.join(", ", e.getValue()));
                        System.out.println();
                    });
                });
    }
}
