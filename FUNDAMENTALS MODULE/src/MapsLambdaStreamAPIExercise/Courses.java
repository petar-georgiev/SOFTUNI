package Maps;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("end")) {


            String[] data = input.split(" : ");
            String courseName = data[0];
            String studentName = data[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);

            input = scan.nextLine();

        }
        courses.entrySet().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream()
                            .sorted()
                            .forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}
