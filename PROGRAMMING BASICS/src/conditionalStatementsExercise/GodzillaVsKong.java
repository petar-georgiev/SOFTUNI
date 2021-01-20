package conditionalStatementsExercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budjet = Double.parseDouble(scan.nextLine());
        int statisti = Integer.parseInt(scan.nextLine());
        double priceOfClothStatist = Double.parseDouble(scan.nextLine());
        double priceOfClothForAllStatist = priceOfClothStatist * statisti;
        double decor = budjet * 0.1;

        if (statisti > 150) {
            priceOfClothForAllStatist *= 0.9;
        }
        if ((decor + priceOfClothForAllStatist) > budjet) {
            double leftPrice = Math.abs(budjet - (decor + priceOfClothForAllStatist));
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", leftPrice);        }
        if ((decor + priceOfClothForAllStatist) <= budjet) {
            double leftPrice = (budjet - (decor + priceOfClothForAllStatist));
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", leftPrice);
        }
    }
}
