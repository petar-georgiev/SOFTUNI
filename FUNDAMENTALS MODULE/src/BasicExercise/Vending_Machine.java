package BasicExercise;

import java.util.Scanner;

public class Vending_Machine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sumCoins = 0;
        double nuts = 2.0;
        double water = 0.7;
        double crisps = 1.5;
        double soda = 0.8;
        double coke = 1.0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            sumCoins += coins;
            input = scan.nextLine();

            if ((coins == 0.1) || (coins == 0.2) || (coins == 0.5) || (coins == 1) || (coins == 2)) {
                continue;
            } else {
                sumCoins -= coins;
                System.out.printf("Cannot accept %.2f%n", coins);
            }

        }
        String input2 = scan.nextLine();

        while (!input2.equals("End")) {

            if ((input2.equals("Coke")) || (input2.equals("Soda")) || (input2.equals("Crisps")) || (input2.equals("Nuts")) || (input2.equals("Water"))) {
                if (sumCoins < 0) {
                    System.out.println("Sorry, not enough money");

                } else {

                    switch (input2) {
                        case "Coke":
                            sumCoins -= coke;
                            if (sumCoins < 0) {
                                sumCoins += coke;
                                System.out.println("Sorry, not enough money");
                                break;
                            }
                            System.out.println("Purchased Coke");
                            break;
                        case "Soda":
                            sumCoins -= soda;
                            if (sumCoins < 0) {
                                sumCoins += soda;
                                System.out.println("Sorry, not enough money");
                                break;
                            }
                            System.out.println("Purchased Soda");
                            break;
                        case "Crisps":
                            sumCoins -= crisps;
                            if (sumCoins < 0) {
                                sumCoins += crisps;
                                System.out.println("Sorry, not enough money");
                                break;
                            }
                            System.out.println("Purchased Crisps");
                            break;
                        case "Nuts":
                            sumCoins -= nuts;
                            if (sumCoins < 0) {
                                sumCoins += nuts;
                                System.out.println("Sorry, not enough money");
                                break;
                            }
                            System.out.println("Purchased Nuts");
                            break;
                        case "Water":
                            sumCoins -= water;
                            if (sumCoins < 0) {
                                sumCoins += water;
                                System.out.println("Sorry, not enough money");
                                break;
                            }
                            System.out.println("Purchased Water");
                            break;
                    }
                    input2 = scan.nextLine();
                    continue;
                }
            } else {
                System.out.println("Invalid product");
            }


            input2 = scan.nextLine();

        }
        System.out.printf("Change: %.2f", sumCoins);
    }
}
