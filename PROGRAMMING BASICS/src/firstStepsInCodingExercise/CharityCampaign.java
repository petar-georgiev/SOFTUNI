package firstStepsInCodingExercise;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        int Days = scan.nextInt();
        int confectioners = scan.nextInt();
        int cakes = scan.nextInt();
        int waffle = scan.nextInt();
        int pancake = scan.nextInt();

        double cakePrice = cakes * 45;
        double wafflePrice = waffle * 5.80;
        double pancakePrice = pancake * 3.20;

        double confectionersOneDayPrice = (cakePrice + wafflePrice + pancakePrice) * confectioners;
        double allCollectedSum = confectionersOneDayPrice * Days;
        double RemainSum = allCollectedSum - (allCollectedSum / 8);

        System.out.printf("%.2f", RemainSum);
    }
}
