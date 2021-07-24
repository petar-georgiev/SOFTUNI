package SetsAndMapsAdvancedLab;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> graduationMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            List<Double> grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());


            graduationMap.putIfAbsent(name, new ArrayList<>());
            graduationMap.put(name, grades);
        }
        graduationMap.entrySet().stream()
                .forEach(s -> {
                    String name = s.getKey();
                    double gradeAvr = s.getValue().stream().mapToDouble(e -> e)
                            .average().getAsDouble();
                    System.out.printf("%s is graduated with %f%n", name, gradeAvr);
                });
    }
}
