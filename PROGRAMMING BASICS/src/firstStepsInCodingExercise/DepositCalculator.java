package firstStepsInCodingExercise;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double depositSum = scan.nextDouble();
        int depositTerm = scan.nextInt();
        double interestRate = scan.nextDouble();

        double price = (depositSum + depositTerm * ((depositSum * interestRate / 100) / 12));

        System.out.printf("%.2f", price);

    }
}
