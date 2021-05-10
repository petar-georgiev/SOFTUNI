package MapsLambdaStreamAPIExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> companyUsers = new TreeMap<>();

        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("End")) {
            String[] data = input.split("->");

            companyUsers.putIfAbsent(data[0], new LinkedList<>());
            if (!companyUsers.get(data[0]).contains(data[1]))
                companyUsers.get(data[0]).add(data[1]);

            input = scan.nextLine();
        }
        companyUsers.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());
                    entry.getValue().stream()
                            .forEach(s -> System.out.printf("--%s%n", s));
                });
    }
}

