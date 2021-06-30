package ExamMidSecond;

import java.util.Scanner;

public class ProblemFirst {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());
        double collectedMoney = 0.0;

        for (int i = 1; i <= months; i++) {
            collectedMoney += neededMoney * 0.25;
            if (i % 2 != 0 && i != 1) {
                collectedMoney -= neededMoney * 0.25;
                collectedMoney -= collectedMoney * 0.16;
                collectedMoney += neededMoney * 0.25;
            }
            if (i % 4 == 0) {
                collectedMoney -= neededMoney * 0.25;
                collectedMoney += collectedMoney * 0.25;
                collectedMoney += neededMoney * 0.25;
            }
        }
        if (collectedMoney >= neededMoney)
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs."
                    , collectedMoney - neededMoney);
        else
            System.out.printf("Sorry. You need %.2flv. more.", neededMoney - collectedMoney);
    }
}
