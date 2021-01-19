package conditionalStatementsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ToyShop {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double excursionPrice = scan.nextDouble();
        int puzzles = scan.nextInt();
        int tollkingDolls = scan.nextInt();
        int teddyBears = scan.nextInt();
        int minions = scan.nextInt();
        int trucks = scan.nextInt();

        double sum = ((puzzles * 2.60) + (tollkingDolls * 3) + (teddyBears * 4.10) + (minions * 8.20) + (trucks * 2));
        int number = puzzles + tollkingDolls + teddyBears + minions + trucks;

        double finalPrice = sum * 0.75;
        double rent = finalPrice * 0.1;
        double profit = finalPrice - rent;
        double remainMoney = profit - excursionPrice;

        double rent2 = sum * 0.1;
        double profit2 = sum - rent2;
        double remainMoney2 = profit2 - excursionPrice;

        if ((number >= 50) && (profit >= excursionPrice)) {
            System.out.printf("Yes! %.2f lv left.", remainMoney);
        } else if ((number < 50) && (profit2 >= excursionPrice)) {
            System.out.printf("Yes! %.2f lv left.", remainMoney2);
        } else if ((number >= 50) && (profit < excursionPrice)) {
            System.out.println("Not enough money! " + df.format(Math.abs(remainMoney)) + " lv needed.");
        } else if ((number < 50) && (profit2 < excursionPrice)) {
            System.out.println("Not enough money! " + df.format(Math.abs(remainMoney2)) + " lv needed.");

        }
    }
}

