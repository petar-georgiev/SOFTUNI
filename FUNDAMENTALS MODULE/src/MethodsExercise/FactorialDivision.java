package MethodsExercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = Double.parseDouble(scan.nextLine());
        double b = Double.parseDouble(scan.nextLine());
        double result = getFactorial(a)/getFactorial(b);
        System.out.printf("%.2f",result);

    }

    public static double getFactorial(double a) {
        double factorial = 1.0;
        for (int i = 1; i <= a ; i++) {
            factorial=factorial*i;
        }
        return factorial;
    }

}

