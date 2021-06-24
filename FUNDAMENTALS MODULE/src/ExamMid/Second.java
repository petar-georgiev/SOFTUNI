package ExamMid;

import java.util.*;
import java.util.stream.Collectors;

public class Second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "reverse":
                    int startIndex = Integer.parseInt(tokens[2]);
                    int count = Integer.parseInt(tokens[4]);

                    if ((startIndex >= 0 && startIndex <= numbersList.size() - 1) &&
                            (startIndex + count >= 0 && startIndex + count <= numbersList.size() - 1))
                        Collections.reverse(numbersList.subList(startIndex, startIndex + count));
                    break;

                case "sort":
                    startIndex = Integer.parseInt(tokens[2]);
                    count = Integer.parseInt(tokens[4]);
                    if ((startIndex >= 0 && startIndex <= numbersList.size() - 1) &&
                            (startIndex + count >= 0 && startIndex + count <= numbersList.size() - 1))
                        Collections.sort(numbersList.subList(startIndex, startIndex + count));
                    break;

                case "remove":
                    int index = Integer.parseInt(tokens[1]);
                    if ((index >= 0 && index <= numbersList.size() - 1))
                        numbersList.subList(0, index).clear();
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
