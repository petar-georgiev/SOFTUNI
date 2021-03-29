package ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
         int input = Integer.parseInt(scan.nextLine());
         sum+=input;
            System.out.printf("%d ",input);
        }
        System.out.println();
        System.out.println(sum);
    }
}
