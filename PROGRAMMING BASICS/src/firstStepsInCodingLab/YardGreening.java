package firstStepsInCodingLab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("input values: ");

        double area = scan.nextDouble();
        double greeningArea = area * 7.61;

        double discount = greeningArea * 0.18;
        double finalPrice = greeningArea - discount;

        System.out.printf("The final price is: %.2f lv. %nThe discount is: %.2f lv.", finalPrice, discount);
    }
}