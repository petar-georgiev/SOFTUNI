package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbersPartOne = numbers.stream().filter(f -> f % 2 == 0).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Integer> numbersPartTwo = numbers.stream().filter(f -> f % 2 != 0).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        numbersPartOne.forEach(s -> System.out.print(s + " "));
        numbersPartTwo.forEach(s -> System.out.print(s + " "));
    }
}
