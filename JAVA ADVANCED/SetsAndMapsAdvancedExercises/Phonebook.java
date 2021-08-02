package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phonebookMap = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            phonebookMap.putIfAbsent(name, "");
            phonebookMap.put(name, phoneNumber);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            if (phonebookMap.containsKey(input))
                System.out.printf("%s -> %s%n", input, phonebookMap.get(input));
            else
                System.out.printf("Contact %s does not exist.%n", input);
            input = scan.nextLine();
        }

    }
}
