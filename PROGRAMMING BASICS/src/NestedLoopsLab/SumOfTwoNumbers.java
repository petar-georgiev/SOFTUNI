package NestedLoopsLab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int sum = Integer.parseInt(scan.nextLine());
        int counter = 0;
        boolean flag = false;
        for (int startNumber = n; startNumber <= m; startNumber++) {

            for (int endNumber = n; endNumber <= m; endNumber++) {
                counter++;
                if (startNumber + endNumber == sum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, startNumber, endNumber, sum);
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            System.out.printf("%d combinations - neither equals %d", counter, sum);

        }
    }
}
