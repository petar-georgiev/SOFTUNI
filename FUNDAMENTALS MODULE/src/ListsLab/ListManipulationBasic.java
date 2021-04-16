package ListsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumber(scan);

        manipulateList(numbers, scan);

        printList(numbers);
    }

    private static List<Integer> manipulateList(List<Integer> editedList, Scanner scan) {

        String inputLine = scan.nextLine();

        while (!inputLine.equals("end")) {
            String[] tokens = inputLine.split(" ");

            switch (tokens[0]) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    editedList.add(number);
                    break;
                case "Remove":
                    number = Integer.parseInt(tokens[1]);
                    editedList.remove(number);
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(tokens[1]);
                    editedList.remove(index);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    index = Integer.parseInt(tokens[2]);
                    editedList.add(index, number);
                    break;
            }
            inputLine = scan.nextLine();
        }
        return editedList;
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
