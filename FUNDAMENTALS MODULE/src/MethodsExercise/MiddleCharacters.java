package MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        getMiddleChar(input);
    }

    private static void getMiddleChar(String input) {
        if (input.length() % 2 == 0)
            System.out.println(input.charAt(((input.length() / 2)) - 1) + "" + input.charAt(input.length() / 2));
        else
            System.out.println(input.charAt(input.length() / 2));

    }
}
