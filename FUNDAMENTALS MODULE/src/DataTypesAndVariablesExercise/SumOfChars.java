package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char letter = scan.next().charAt(0);
            sum = sum + (int) letter;
        }
        System.out.println("The sum equals: " + sum);
    }
}
