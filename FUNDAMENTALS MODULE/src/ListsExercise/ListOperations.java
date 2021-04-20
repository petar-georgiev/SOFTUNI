package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumber(scan);

        String inputLine = scan.nextLine();

        while (!inputLine.equals("End")) {
            String[] tokens = inputLine.split(" ");

            if (tokens[0].equals("Add")) {
                int number = Integer.parseInt(tokens[1]);
                numbers.add(number);
            } else if (tokens[0].equals("Insert")) {
                int number = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                if(index>numbers.size()-1){
                    System.out.println("Invalid index %n");
                    inputLine = scan.nextLine();
                    continue;
                }else
                numbers.add(index,number);
            } else if (tokens[0].equals("Remove")) {
                int index = Integer.parseInt(tokens[1]);
                if(index>numbers.size()-1){
                    System.out.println("Invalid index");
                    inputLine = scan.nextLine();
                    continue;
                }
                numbers.remove(index);
            } else if (tokens[0].equals("Shift")) {
                if (tokens[1].equals("left")) {
                    int count = Integer.parseInt(tokens[2]);
                    for (int i = 0; i < count; i++) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }
                } else if (tokens[1].equals("right")) {
                    int count = Integer.parseInt(tokens[2]);
                    for (int i = 0; i < count; i++) {
                        numbers.add(0, numbers.get(numbers.size() - 1));
                        numbers.remove(numbers.size() - 1);
                    }
                }
            }
            inputLine = scan.nextLine();

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
