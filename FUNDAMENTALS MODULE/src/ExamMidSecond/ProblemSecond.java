package ExamMidSecond;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemSecond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> biscuitList = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("Eat")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Update-Any":
                    for (String biscuit : biscuitList) {
                        if (tokens[1].equals(biscuit)) {
                            biscuitList.set(biscuitList.indexOf(biscuit), "Out of stock");
                        }
                    }
                    break;

                case "Remove":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= biscuitList.size() - 1) {
                        biscuitList.set(index, tokens[1]);
                    }
                    break;

                case "Update-Last":
                    biscuitList.set(biscuitList.size() - 1, tokens[1]);
                    break;

                case "Rearrange":
                    if (biscuitList.contains(tokens[1])) {
                        biscuitList.remove(tokens[1]);
                        biscuitList.add(tokens[1]);
                    }
                    break;

            }
            input = scan.nextLine();
        }
        biscuitList.remove("Out of stock");
        System.out.println(String.join(" ", biscuitList));
    }
}
