package ListsLab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = parseLineOfNumber(scan);

        int i = 0;
        while (i < numbers.size() - 1) {
            double current = numbers.get(i);
            double next = numbers.get(i + 1);
            if (current == next) {
                numbers.remove(i);
                numbers.set(i, current + next);
                i = 0;
            } else {
                i++;
            }
        }


        for (double number : numbers) {
            System.out.print(new DecimalFormat("0.#").format(number) + " ");

        }
    }


    private static List<Double> parseLineOfNumber(Scanner scan) {
        String line = scan.nextLine();

        String[] numbersAsString = line.split(" ");

        List<Double> numbers = new ArrayList<>();
        for (String s : numbersAsString) {
            double number = Double.parseDouble(s);
            numbers.add(number);
        }
        return numbers;
    }
}

