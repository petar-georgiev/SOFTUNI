package ListsExercise;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumber(scan);

        String inputLine = scan.nextLine();

        while (!inputLine.equals("end")) {
            String[] tokens = inputLine.split(" ");

            if (tokens[0].equals("Delete")) {
                int number = Integer.parseInt(tokens[1]);
                while (numbers.contains(number)) {
                    numbers.remove(new Integer(number));

                }
            } else if (tokens[0].equals("Insert")) {
                int number = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                numbers.add(index, number);
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
