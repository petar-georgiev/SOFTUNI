package ListsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = parseLineOfNumber(scan);

        manipulateList(numbers, scan);


    }

    private static List<Integer> manipulateList(List<Integer> editedList, Scanner scan) {

        String inputLine = scan.nextLine();

        while (!inputLine.equals("end")) {
            String[] tokens = inputLine.split(" ");


            switch (inputLine) {

                case "Print even":
                    for (int each : editedList) {
                        if (each % 2 == 0) {
                            System.out.print(each + " ");

                        }
                    }
                    System.out.println();
                    break;
                case "Print odd":
                    for (int each : editedList) {
                        if (each % 2 != 0) {
                            System.out.print(each + " ");

                        }
                    }
                    System.out.println();
                    break;
                case "Get sum":
                    int sum = 0;
                    for (int each : editedList) {
                        sum += each;
                    }
                    System.out.println(sum);
                    break;
            }
            if (tokens[0].equals("Contains")) {
                int number = Integer.parseInt(tokens[1]);
                if (editedList.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            }
            if (tokens[0].equals("Filter")) {
                if (tokens[1].equals(">=")) {
                    int number = Integer.parseInt(tokens[2]);
                    for (int each : editedList) {
                        if (each >= number) {
                            System.out.print(each + " ");
                        }
                      }
                    System.out.println();
                } else if (tokens[1].equals("<")) {
                    int number = Integer.parseInt(tokens[2]);
                    for (int each : editedList) {
                        if (each < number) {
                            System.out.print(each + " ");
                        }

                    }
                    System.out.println();
                }
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
