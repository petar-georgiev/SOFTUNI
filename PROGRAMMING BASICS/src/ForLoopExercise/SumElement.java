package ForLoopExercise;

import java.util.Scanner;

public class SumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int quantity = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < quantity; i++) {
            int number = scan.nextInt();
            sum += number;

            if (number > max) {
                max = number;
            }

        }
        if(max==(sum-max)){
            System.out.printf("Yes %nSum = %d", max);
        }
        else {
            System.out.printf("No %nDiff = %d", Math.abs(max-(sum-max)));
        }
    }
}
