package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String flower = scan.nextLine();
        int quantityFlower = Integer.parseInt(scan.nextLine());
        int budjet = Integer.parseInt(scan.nextLine());
        double price = 0.0;
        double pro = 0.0;

        switch (flower) {
            case "Roses":
                price = 5;
                break;
            case "Dahlias":
                price = 3.80;
                break;
            case "Tulips":
                price = 2.80;
                break;
            case "Narcissus":
                price = 3;
                break;
            case "Gladiolus":
                price = 2.50;
                break;
        }
        if (flower.equals("Roses") && quantityFlower > 80) {
            pro = price * 0.1;
            price = price - pro;
        }
        if (flower.equals("Dahlias") && quantityFlower > 90) {
            pro = price * 0.15;
            price = price - pro;
        }
        if (flower.equals("Tulips") && quantityFlower > 80) {
            pro = price * 0.15;
            price = price - pro;
        }
        if (flower.equals("Narcissus") && quantityFlower < 120) {
            pro = price * 0.15;
            price = price + pro;
        }
        if (flower.equals("Gladiolus") && quantityFlower < 80) {
            pro = price * 0.20;
            price = price + pro;
        }
        double allPrice = price * quantityFlower;
        if (budjet >= allPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quantityFlower, flower, budjet - allPrice);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", allPrice - budjet);
        }
    }
}
