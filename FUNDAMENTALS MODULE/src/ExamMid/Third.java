package ExamMid;

import java.util.*;
import java.util.stream.Collectors;

public class Third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> cardsList = Arrays.stream(scan.nextLine().split("\\:"))
                .collect(Collectors.toList());
        List<String> mineCarsList = new LinkedList<>();

        String input = scan.nextLine();
        while (!input.equals("Ready")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    if (cardsList.contains(tokens[1]))
                        mineCarsList.add(tokens[1]);
                    else
                        System.out.println("Card not found.");
                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= mineCarsList.size() - 1&&cardsList.contains(tokens[1])) {
                        mineCarsList.add(Integer.parseInt(tokens[2]), tokens[1]);
                    } else {
                        System.out.println("Error!");
                    }
                    break;

                case "Remove":
                    if (mineCarsList.contains(tokens[1]))
                        mineCarsList.remove(tokens[1]);
                    else
                        System.out.println("Card not found.");
                    break;

                case "Swap":
                    int getIndexFirst = mineCarsList.indexOf(tokens[1]);
                    int getIndexSecond = mineCarsList.indexOf(tokens[2]);

                    mineCarsList.set(getIndexFirst, tokens[2]);
                    mineCarsList.set(getIndexSecond, tokens[1]);
                    break;

                case "Shuffle":
                    Collections.reverse(mineCarsList);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(" ", mineCarsList));
    }
}