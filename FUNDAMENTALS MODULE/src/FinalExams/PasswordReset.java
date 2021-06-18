package FinalExams;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        String input = scan.nextLine();
        while (!input.equals("Done")) {
            if (input.equals("TakeOdd")) {
                password = takeOdd(password);
                System.out.println(password);
            }
            String[] tokens = input.split("\\s");
            if (tokens[0].equals("Cut")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]) + startIndex;
                String substring = password.substring(startIndex, endIndex);
                password = password.replaceFirst(substring, "");
                System.out.println(password);
            }
            if (tokens[0].equals("Substitute")) {
                if (password.contains(tokens[1])) {
                    password = password.replace(tokens[1], tokens[2]);
                    System.out.println(password);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }

            input = scan.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }

    private static String takeOdd(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < password.length(); i += 2) {
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }


}
