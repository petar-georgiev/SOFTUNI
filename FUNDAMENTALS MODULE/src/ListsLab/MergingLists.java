package ListsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = parseLineOfNumber(scan);
        List<Integer> secondList = parseLineOfNumber(scan);

        List<Integer> mergedList = new ArrayList<>();
        int indexInFirst = 0;
        int indexInSecond = 0;

        while (indexInFirst < firstList.size() || indexInSecond < secondList.size()) {

            if (indexInFirst < firstList.size()) {
                int getNumber = firstList.get(indexInFirst);
                mergedList.add(getNumber);
            }
            if (indexInSecond < secondList.size()) {
                int getNumber2 = secondList.get(indexInSecond);
                mergedList.add(getNumber2);
            }

            indexInFirst++;
            indexInSecond++;
        }

        printList(mergedList);
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


