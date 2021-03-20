package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Sum_Digit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            int intDigit = Integer.parseInt(String.valueOf(digit));
            sum += intDigit;
        }
        System.out.println(sum);
    }
}
