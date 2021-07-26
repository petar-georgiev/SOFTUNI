package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentsNum = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < studentsNum; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            Double grade = Double.parseDouble(tokens[1]);

            studentsMap.putIfAbsent(name, new ArrayList<>());
            studentsMap.get(name).add(grade);
        }

        studentsMap.forEach((key, value) -> {
            String allGrades = value.stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));
            double avr = value.stream()
                    .mapToDouble(e -> e)
                    .average().getAsDouble();
            System.out.printf("%s -> %s (avg: %.2f)%n", key, allGrades, avr);
        });
    }
}
