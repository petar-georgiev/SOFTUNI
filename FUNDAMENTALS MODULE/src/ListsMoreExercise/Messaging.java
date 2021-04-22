package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        List<String> text = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());

        List<Integer> sum = getListSumOfNumbers(numbers, scan);
        List<String> exportList = new ArrayList<>();


        for (int i = 0; i < sum.size(); i++) {
            if (sum.get(i) > text.size() - 1) {
                exportList.add(text.get(sum.get(i) - text.size()));
                text.remove(text.get(sum.get(i) - text.size()));
            } else {
                exportList.add(text.get(sum.get(i)));
                text.remove(text.get(sum.get(i)));
            }
        }
        for (String s : exportList) {
            System.out.print(s);
        }
    }

    public static List<Integer> getListSumOfNumbers(List<String> input, Scanner scan) {
        List<Integer> sumOfNumbers = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            String[] elements = input.get(i).split("");

            for (int j = 0; j < elements.length; j++) {
                sum += Integer.parseInt(elements[j]);
            }
            sumOfNumbers.add(sum);
        }
        return sumOfNumbers;
    }
}
