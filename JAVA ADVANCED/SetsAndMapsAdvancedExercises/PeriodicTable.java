package SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> compoundsSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            compoundsSet.addAll(Arrays.asList(scan.nextLine().split("\\s+")));
        }
        compoundsSet.forEach(s -> System.out.print(s + " "));
    }
}
