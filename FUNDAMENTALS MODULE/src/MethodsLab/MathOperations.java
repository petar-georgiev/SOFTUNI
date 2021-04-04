package MethodsLab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        String operation = scan.nextLine();
        int b = Integer.parseInt(scan.nextLine());
        System.out.printf("%.0f",calculate(a,operation,b));

    }
    private static double calculate(int a,String operator, int b){
        double result = 0.0;

        switch (operator){
            case "/":
                result=a/b;
                break;
            case "*":
                result=a*b;
                break;
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
        }
        return result;
    }
}
