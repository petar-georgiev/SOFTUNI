package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Character, Integer> symbolsMap = new TreeMap<>();

        String[] symbols = scan.nextLine().split("");
        int counter = 0;
        for (String symbol : symbols) {
            symbolsMap.putIfAbsent(symbol.charAt(0), 0);
            symbolsMap.put(symbol.charAt(0), symbolsMap.get(symbol.charAt(0)) + 1);
        }
        symbolsMap.forEach((key, value) ->
                System.out.printf("%c: %d time/s%n", key, value));
    }
}
