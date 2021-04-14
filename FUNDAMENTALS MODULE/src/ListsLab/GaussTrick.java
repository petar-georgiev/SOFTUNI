package ListsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumber(scan);

        int getSize = numbers.size();
        for (int i = 0, j = numbers.size() - 1; i <= numbers.size() && j > 0; i++, j--) {
            if (numbers.size() > (getSize / 2)) {
                int first = numbers.get(i);
                int last = numbers.get(j);

                if (getSize % 2 != 0) {

                    if (numbers.size() > (getSize - (getSize / 2))) {
                        numbers.set(i, first + last);
                        numbers.remove(j);
                    } else {
                        break;
                    }
                } else {
                    numbers.set(i, first + last);
                    numbers.remove(j);


                }
            }
        }

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
