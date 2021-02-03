package ForLoopLab;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = scan.nextInt();

        int leftSide = 0;
        int rightSide = 0;


        for (int i = 0; i < quantity; i++) {
            int num = scan.nextInt();
            leftSide += num;

        }
        for (int i = 0; i < quantity; i++) {
            int num = scan.nextInt();
            rightSide += num;

        }

        if (leftSide == rightSide)
            System.out.printf("Yes, sum = %d", leftSide);

        else {
            System.out.printf("No, diff = %d", Math.abs(leftSide - rightSide));
        }
    }
}
