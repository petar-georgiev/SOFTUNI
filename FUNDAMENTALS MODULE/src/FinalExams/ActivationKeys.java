package FinalExams;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String ActKey = scan.nextLine();

        String input = scan.nextLine();
        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];
                    if (ActKey.contains(substring))
                        System.out.println(ActKey + "contains" + substring);
                    else
                        System.out.println("Substring not found!");
                    break;

                case "Flip":
                    String option = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    if (option.equals("Upper")) {
                        ActKey = ActKey.replace(ActKey.substring(startIndex, endIndex),
                                ActKey.substring(startIndex, endIndex).toUpperCase());
                        System.out.println(ActKey);
                    } else {
                        ActKey = ActKey.replace(ActKey.substring(startIndex, endIndex),
                                ActKey.substring(startIndex, endIndex).toLowerCase());
                        System.out.println(ActKey);
                    }
                    break;

                case "Slice":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    String sliceSub = ActKey.substring(startIndex, endIndex).trim();
                    ActKey = ActKey.replace(sliceSub, "");
                    System.out.println(ActKey);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s", ActKey);
    }
}
