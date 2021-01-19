package firstStepsInCodingLab;

import java.util.Scanner;

public class PetShop {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        double dogs = scan.nextDouble();
        double remainDogs = scan.nextDouble();

        double dogsPrice = dogs * 2.50;
        double remainDogsPrice = remainDogs * 4.0;
        double sum = remainDogsPrice + dogsPrice;

        System.out.printf("%.2f lv.", sum);
    }
}
