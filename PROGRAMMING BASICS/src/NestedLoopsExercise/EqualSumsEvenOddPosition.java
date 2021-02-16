package NestedLoopsExercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            String number = "" + i;
            int oddSum = 0;
            int evenSum = 0;

            for (int j = 0; j < number.length(); j++) {
                int currentDigit = Integer.parseInt("" + number.charAt(j));
                if (j % 2 == 0) {
                    evenSum += currentDigit;
                } else {
                    oddSum += currentDigit;
                }
            }
            if (oddSum==evenSum){
                System.out.print(i+" ");
            }
        }
    }
}
