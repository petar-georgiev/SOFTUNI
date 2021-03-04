package BasicExercise;

import java.util.Scanner;

public class Strong_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputNum = Integer.parseInt(scan.nextLine());
        int checkNum = inputNum;

        int factorialSum = 0;

        while (checkNum != 0) {

            int result = checkNum % 10;
            checkNum /= 10;

            int factorial = 1;
            for (int i = 1; i <= result; i++) {
                factorial *= i;
            }
            factorialSum += factorial;
        }
        if (factorialSum == inputNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
