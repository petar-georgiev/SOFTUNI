package FinalExams;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] instructions = input.split(":\\|:");

            switch (instructions[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(instructions[1]);
                    message.insert(index, " ");
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(instructions[1]);
                    if (message.toString().contains(substring)) {
                        int startIndex = message.indexOf(substring.toString());
                        message.replace(startIndex, startIndex + substring.length(), "");
                        message.append(substring.reverse());
                    } else {
                        System.out.println("error");
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "ChangeAll":
                    String string = instructions[1];
                    String replacement = instructions[2];
                    message = new StringBuilder(message.toString().replace(string, replacement));
                    break;
            }

            System.out.println(message.toString());

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", message.toString());

    }
}
