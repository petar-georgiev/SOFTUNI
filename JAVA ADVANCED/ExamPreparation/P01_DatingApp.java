package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> male = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(male::push);
        ArrayDeque<Integer> female = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(female::offer);

        int matches = 0;

        while (!(male.isEmpty() || female.isEmpty())) {

            isDivisibleBy25(male);
            isDivisibleBy25(female);
            if (!(male.isEmpty() || female.isEmpty())) {
                EqualOrBelowZero(male);
                EqualOrBelowZero(female);
                if (male.peek().equals(female.peek())) {
                    EqualOrBelowZero(male);
                    EqualOrBelowZero(female);
                    isDivisibleBy25(male);
                    isDivisibleBy25(female);
                    male.pop();
                    female.poll();
                    matches++;
                } else if ((!male.peek().equals(female.peek())) ||
                        (!(isDivisibleBy25(male) || isDivisibleBy25(female)))) {
                    EqualOrBelowZero(male);
                    EqualOrBelowZero(female);
                    isDivisibleBy25(male);
                    isDivisibleBy25(female);
                    if (male.peek().equals(female.peek())) {
                        male.pop();
                        female.poll();
                        matches++;
                        break;
                    }
                    female.poll();
                    male.push(male.pop() - 2);
                }
            }
        }
        System.out.println("Matches: " + matches);
        System.out.printf("Males left: %s%n", formatArrayDeque(male));
        System.out.printf("Females left: %s%n", formatArrayDeque(female));

    }

    private static boolean EqualOrBelowZero(ArrayDeque<Integer> gender) {
        if (gender.peek() <= 0) {
            gender.pop();
            return true;
        }
        return false;
    }

    private static boolean isDivisibleBy25(ArrayDeque<Integer> gender) {
        int currentValue = gender.peek();
        if (currentValue % 25 == 0 && currentValue != 0 && !gender.isEmpty()) {
            gender.pop();
            if (!gender.isEmpty()) {
                gender.pop();
            }
            return true;
        }
        return false;
    }

    private static String formatArrayDeque(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        } else {
            return deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
        }
    }
}
