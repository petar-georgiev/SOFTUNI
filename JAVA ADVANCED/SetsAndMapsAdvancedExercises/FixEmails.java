package SetsAndMapsAdvancedExercises;

import java.sql.Array;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> emailMap = new LinkedHashMap<>();
        String input = scan.nextLine();
        String[] optionArr = {"uk", "com", "us"};
        boolean flag = false;

        while (!input.equals("stop")) {
            String name = input;
            String email = scan.nextLine();

            if (!email.endsWith("us") && !email.endsWith("com")
                    && !email.endsWith("uk")) {
                emailMap.putIfAbsent(name, " ");
                emailMap.put(name, email);
            }

            input = scan.nextLine();
        }
        emailMap.forEach((key, value) -> {
            System.out.printf("%s -> %s%n", key, value);
        });

    }
}
