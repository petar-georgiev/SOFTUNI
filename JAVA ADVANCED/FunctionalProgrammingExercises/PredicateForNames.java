package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(f -> f.length() <= length).forEach(System.out::println);
    }
}
