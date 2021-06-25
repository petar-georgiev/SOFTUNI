package ExamFInal;

import java.util.Locale;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        String input = scan.nextLine();
        while (!input.equals("Sign up")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Case":
                    if (tokens[1].equals("lower")) {
                        name = name.toLowerCase(Locale.ROOT);
                        System.out.println(name);
                    } else {
                        name = name.toUpperCase(Locale.ROOT);
                        System.out.println(name);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if ((startIndex >= 0 && startIndex < name.length() - 1) &&
                            (endIndex > 0 && endIndex <= name.length() - 1)) {
                        System.out.println(reverse(name, startIndex, endIndex));
                    }
                    break;
                case "Cut":
                    if (!name.contains(tokens[1])) {
                        System.out.printf("The world %s doesn't contain %s.%n", name, tokens[1]);
                    } else {
                        name = name.replace(tokens[1], "");
                        System.out.println(name);
                    }

                    break;
                case "Replace":
                    for (int i = 0; i < name.length(); i++) {
                        if (name.charAt(i) == tokens[1].charAt(0)) {
                            name = name.replace(name.charAt(i), '*');
                        }
                    }
                    System.out.println(name);
                    break;
                case "Check":
                    if (name.contains(tokens[1])) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", tokens[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
    }

    private static String reverse(String name, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder(name);
        StringBuilder sbNew = new StringBuilder(sb.substring(startIndex, endIndex + 1));
        sbNew.reverse();
        return sbNew.toString();
    }
}
