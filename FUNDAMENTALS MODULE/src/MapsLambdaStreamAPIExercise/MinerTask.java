package MapsLambdaStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> mine = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("stop")) {

            int quantity = Integer.parseInt(scan.nextLine());

            if (!mine.containsKey(input)) {
                mine.put(input, quantity);
            } else {
                mine.put(input, mine.get(input) + quantity);
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : mine.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
