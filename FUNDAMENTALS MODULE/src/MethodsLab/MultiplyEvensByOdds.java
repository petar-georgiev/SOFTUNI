package MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {


    public static int multiplyEvenOdd(String number) {
        int parsNum= Integer.parseInt(number);
        int evenSum = 0;
        int oddSum = 0;
        int multipy = 0;

        for (int i = 0; i < number.length(); i++) {
            if (i % 2 == 0) {
                evenSum += parsNum;
            } else {
                oddSum += parsNum;
            }
        }
        multipy=evenSum*oddSum;
        return multipy;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = (scan.nextLine());
        System.out.println(multiplyEvenOdd(input));
    }

}
