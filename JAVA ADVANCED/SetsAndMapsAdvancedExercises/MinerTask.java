package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> minerMap = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            int quantity = Integer.parseInt(scan.nextLine());
            input = scan.nextLine();
            minerMap.putIfAbsent(name, 0);
            minerMap.put(name, quantity + minerMap.get(name));
        }
        minerMap.forEach((key, value) ->
                System.out.printf("%s -> %d%n", key, value));
    }
}
