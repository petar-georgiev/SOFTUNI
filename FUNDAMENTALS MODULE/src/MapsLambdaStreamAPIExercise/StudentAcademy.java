package MapsLambdaStreamAPIExercise;

import java.util.*;
import java.util.stream.Stream;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new LinkedHashMap<>();


        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String studentName = scan.nextLine();
            Double studentGrade = Double.parseDouble(scan.nextLine());

            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(studentGrade);
        }
students.entrySet().stream()
        .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue)
                .average().getAsDouble()>=4.50)
        .sorted((s1,s2)->{
            double first = s1.getValue().stream().mapToDouble(Double::doubleValue)
                    .average().getAsDouble();
            double second = s2.getValue().stream().mapToDouble(Double::doubleValue)
                    .average().getAsDouble();
            return Double.compare(second,first);
        })
    .forEach(s -> System.out.printf("%s -> %.2f%n",
            s.getKey(),
            s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));
    }
}
