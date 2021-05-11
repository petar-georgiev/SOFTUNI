package MapsLambdaStreamAPIExercise;

import java.util.*;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        Map<Character, Integer> counterMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                if (counterMap.containsKey(c)) {
                    int counter = counterMap.get(c);
                    counterMap.put(c, counter + 1);
                } else {
                    counterMap.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : counterMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
