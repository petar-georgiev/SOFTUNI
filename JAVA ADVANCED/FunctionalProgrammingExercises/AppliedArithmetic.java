package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("end")) {

            switch (input) {
                case "add":
                    numbers = addNumbers(numbers);
                    break;
                case "multiply":
                    numbers = multiplyNumbers(numbers);
                    break;
                case "subtract":
                    numbers = subtractNumbers(numbers);
                    break;
                case "print":
                    print(numbers);
                    System.out.println();
            }

            input = scan.nextLine();
        }
    }

    private static List<Integer> subtractNumbers(List<Integer> numbers) {
        numbers = numbers.stream().map(x -> x - 1).collect(Collectors.toList());
        return numbers;
    }

    private static List<Integer> multiplyNumbers(List<Integer> numbers) {
        numbers = numbers.stream().map(x -> x * 2).collect(Collectors.toList());
        return numbers;
    }

    private static List<Integer> addNumbers(List<Integer> numbers) {
        numbers = numbers.stream().map(x -> x + 1).collect(Collectors.toList());
        return numbers;
    }

    private static void print(List<Integer> numbers) {
        numbers.forEach(s -> System.out.print(s + " "));
    }


}
