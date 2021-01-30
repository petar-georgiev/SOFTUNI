package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        String symbol = scan.nextLine();
        int result = 0;
        double resultDevide = 0.0;
        String evenOdd = "";

        if (symbol.equals("+")) {
            result = n1 + n2;
            if (result % 2 == 0) {
                evenOdd = "even";
            } else {
                evenOdd = "odd";
            }
        }
        if (symbol.equals("-")) {
            result = n1 - n2;
            if (result % 2 == 0) {
                evenOdd = "even";
            } else {
                evenOdd = "odd";
            }
        }
        if (symbol.equals("*")) {
            result = n1 * n2;
            if (result % 2 == 0) {
                evenOdd = "even";
            } else {
                evenOdd = "odd";
            }
        }
        if (symbol.equals("/")) {
            resultDevide = (double) n1 / n2;
        }
        if (symbol.equals("%")) {
            if (n2 == 0) {
                System.out.printf("Cannot divide %d by zero", n1);

            } else {
                result = n1 % n2;
                System.out.printf("%d %s %d = %d", n1, symbol, n2, result);
            }
        }
        if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*")) {
            System.out.printf("%d %s %d = %d - %s", n1, symbol, n2, result, evenOdd);
        }
        if (symbol.equals("/")) {
            if (n2 == 0) {
                System.out.printf("Cannot divide %d by zero", n1);
            } else {
                System.out.printf("%d %s %d = %.2f", n1, symbol, n2, resultDevide);
            }
        }
    }
}
