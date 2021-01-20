package conditionalStatementsExercise;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = Double.parseDouble(scan.nextLine());
        double avSuccess = Double.parseDouble(scan.nextLine());
        double minSalary = Double.parseDouble(scan.nextLine());
        double scholarship = Math.floor(minSalary * 0.35);
        double schoolarshipBySuccess = Math.floor(avSuccess * 25);

        if ((income > minSalary) || (avSuccess < 4.5)) {
            System.out.println("You cannot get a scholarship!");
        }
        if ((income < minSalary) && (avSuccess > 4.5) && (avSuccess < 5.5)) {
            System.out.printf("You get a Social scholarship %.0f BGN", scholarship);
        }
        if ((avSuccess >= 5.5)) {
            if (schoolarshipBySuccess > scholarship) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", schoolarshipBySuccess);
            } else {
                System.out.printf("You get a Social scholarship %.0f BGN", scholarship);
            }
        }
    }
}
