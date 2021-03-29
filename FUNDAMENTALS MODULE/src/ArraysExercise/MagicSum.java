package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (sum == (input[i] + input[j])){

                    System.out.print(input[i]+" "+input[j]);
                    System.out.println();
                }

            }
        }
    }
}
