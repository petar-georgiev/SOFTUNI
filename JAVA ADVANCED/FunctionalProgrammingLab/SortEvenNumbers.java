package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(s->isDivisibleBy(s,2))
                .collect(Collectors.toList());

        if (numbersList.isEmpty()) {
            System.out.println("(no output)");
        } else {
            System.out.println(numbersList.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));

            numbersList.sort(Comparator.naturalOrder());

            System.out.println(numbersList.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }

    private static boolean isDivisibleBy(int number, int divisitor) {
        return number % divisitor == 0;
    }
}
