package ListsLab;

import java.util.*;

public class RemoveNegativeAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumber(scan);


        int counter = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < 0) {
                counter++;
            }
            if (counter == numbers.size() - 1) {
                System.out.println("empty");
            }
        }
        numbers.removeIf(n -> n < 0);
        Collections.reverse(numbers);
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (int each : numbers) {
            System.out.print(each + " ");
        }
    }
    public static List<Integer> parseLineOfNumber(Scanner scan) {
        String[] str = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String each : str) {
            int number = Integer.parseInt(each);
            numbers.add(number);
        }
        return numbers;
    }
}

