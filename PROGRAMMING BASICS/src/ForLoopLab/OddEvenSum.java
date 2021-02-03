package ForLoopLab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = scan.nextInt();
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < quantity; i++) {
            int num = scan.nextInt();

            if (i % 2 == 0) {
                sum += num;
            }
            if (i % 2 == 1) {
                sum2 += num;
            }
        }
        if (sum == sum2) {
            System.out.printf("Yes %nSum = %d", sum);
        } else {
            System.out.printf("No %nDiff = %d", Math.abs(sum - sum2));
        }
    }
}
