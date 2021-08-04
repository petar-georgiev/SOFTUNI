package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lengths = scan.nextLine().split("\\s+");
        int firstLength = Integer.parseInt(lengths[0]);
        int secondLength = Integer.parseInt(lengths[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstLength; i++) {
            firstSet.add(scan.nextInt());
        }
        for (int i = 0; i < secondLength; i++) {
            secondSet.add(scan.nextInt());
        }

        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                System.out.print(integer + " ");
            }
        }
    }
}
