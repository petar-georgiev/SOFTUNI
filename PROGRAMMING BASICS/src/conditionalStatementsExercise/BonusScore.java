package conditionalStatementsExercise;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int initialPoints = scan.nextInt();
        double bonusPoints = 0.0;

        if (initialPoints <= 100) {
            bonusPoints = 5;
        }
        if (initialPoints > 100) {
            bonusPoints = initialPoints * 0.2;
        }
        if (initialPoints > 1000) {
            bonusPoints = initialPoints * 0.1;
        }
        if (initialPoints % 2 == 0) {
            bonusPoints += 1;
        }
        if (initialPoints % 10 == 5) {
            bonusPoints += 2;
        }
        System.out.println(bonusPoints);
        System.out.println(initialPoints + bonusPoints);
    }
}


