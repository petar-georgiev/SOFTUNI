package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!input.equals("END")){
            System.out.println(isPalindrome(input));
            input= scan.nextLine();
        }

    }

    public static boolean isPalindrome(String input) {

        char[] straight = new char[input.length()];
        char[] reverse = new char[input.length()];
        char[] reverseToReverse = new char[input.length()];
        for (int i = 0, j = input.length() - 1; i <= input.length() && j >= 0; i++, j--) {
            straight[i] = input.charAt(i);
            reverse[j] = input.charAt(i);
        }
        for (int i = reverse.length - 1; i >= 0; i--) {
            reverseToReverse[i] = reverse[i];
        }
        if (Arrays.equals(straight, reverseToReverse)) {
            return true;
        } else {
            return false;
        }
    }
}

