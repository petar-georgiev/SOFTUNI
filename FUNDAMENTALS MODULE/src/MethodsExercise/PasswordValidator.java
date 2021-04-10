package MethodsExercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String enter = scan.nextLine();

        if (getCharacters(enter) && getOnlyLettersAndDigits(enter) && getTwoDigits(enter)) {
            System.out.println("Password is valid");
            return;
        }
        if (!getCharacters(enter)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!getOnlyLettersAndDigits(enter)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!getTwoDigits(enter)) {
            System.out.println("Password must have at least 2 digits");
        }
    }



    public static boolean getCharacters(String input) {
        boolean moreThanTenChar = false;
        if (input.length() >= 6 && input.length() <= 10) {
            moreThanTenChar = true;
        }
        return moreThanTenChar;
    }

    public static boolean getOnlyLettersAndDigits(String input) {
        boolean lettersAndDigits = true;
        for (int i = 0; i < input.length(); i++) {

            if ((input.charAt(i) < 48 || input.charAt(i) > 57) &&
                    (input.charAt(i) < 65 || input.charAt(i) > 90) &&
                    (input.charAt(i) < 97 || input.charAt(i) > 122)) {

                lettersAndDigits = false;
            }
        }
        return lettersAndDigits;
    }

    public static boolean getTwoDigits(String input) {
        boolean twoDigits = false;
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                counter++;
                if (counter >= 2) {
                    twoDigits = true;
                }
            }
        }
        return twoDigits;
    }

}
