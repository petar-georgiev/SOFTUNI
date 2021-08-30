package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        int n = Integer.parseInt(scan.nextLine());

        numbers = numbers.stream().filter(f -> (f % n) != 0).collect(Collectors.toList());
        Collections.reverse(numbers);
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}