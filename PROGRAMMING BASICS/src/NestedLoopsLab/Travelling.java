package NestedLoopsLab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        int budjet = 0;
        int money = 0;
        int sum = 0;
        boolean flag = false;

        while (!destination.equals("End")) {

            budjet = Integer.parseInt(scan.nextLine());

            while (sum < budjet) {
                flag = true;
                money = Integer.parseInt(scan.nextLine());
                sum += money;

            }
            if (flag) {
                System.out.printf("Going to %s!%n", destination);
                sum = 0;
            }
            destination = scan.nextLine();

        }
    }
}
