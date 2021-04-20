package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = parseLineOfNumber(scan);

        int maxCapacity = Integer.parseInt(scan.nextLine());
        String inputLine = scan.nextLine();

        while (!inputLine.equals("end")) {
            String[] tokens = inputLine.split(" ");
            if (tokens[0].equals("Add")) {
                int number = Integer.parseInt(tokens[1]);
                wagons.add(number);
            } else {

                int number = Integer.parseInt(inputLine);
                for (int i = 0; i < wagons.size() - 1; i++) {
                        if ((wagons.get(i) < maxCapacity)
                                && (number + wagons.get(i) <= maxCapacity)) {
                            wagons.set(i, (number + wagons.get(i)));
                        break;
                    }
                }
            }
            inputLine = scan.nextLine();
        }
        printList(wagons);
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
