package ForLoopExercise;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double evenMin = 1000000000;
        double evenMax = -1000000000;
        double oddMin = 1000000000;
        double oddMax = -1000000000;
        double evenSum = 0.0;
        double oddSum = 0.0;
        int quantity = Integer.parseInt(scan.nextLine());
        boolean isOddMin = false;
        boolean isOddMax = false;
        boolean isEvenMin = false;
        boolean isEvenMax = false;


        for (int i = 1; i <= quantity; i++) {
            double number = Double.parseDouble(scan.nextLine());
            if (i % 2 == 1) {
                oddSum += number;
                if (number < oddMin) {
                    oddMin = number;
                    isOddMin = true;
                }

                if (number > oddMax) {
                    oddMax = number;
                    isOddMax = true;
                }
            }
            if (i % 2 == 0) {
                evenSum += number;
                if (number < evenMin) {
                    evenMin = number;
                    isEvenMin = true;
                }
                if (number > evenMax) {
                    evenMax = number;
                    isEvenMax = true;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);

        if (isOddMin) {
            System.out.printf("OddMin=%.2f,%n", oddMin);
        } else {
            System.out.println("OddMin=No,");
        }
        if (isOddMax) {
            System.out.printf("OddMax=%.2f,%n", oddMax);

        } else {
            System.out.println("OddMax=No,");
        }

        System.out.printf("EvenSum=%.2f,%n", evenSum);

        if (isEvenMin) {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
        } else {
            System.out.println("EvenMin=No,");
        }

        if (isEvenMax) {
            System.out.printf("EvenMax=%.2f%n", evenMax);

        } else {
            System.out.println("EvenMax=No");

        }
    }
}
