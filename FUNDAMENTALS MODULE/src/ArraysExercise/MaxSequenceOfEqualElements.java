package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int counter = 1;
        int[] counterArray = new int[input.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            counter = 1;
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] != input[j]) {
                    break;
                } else {
                    counter++;
                }
            }
            for (int k = i; k < i + 1; k++) {
                counterArray[k] = counter;

            }
        }
        for (int i = 0; i < counterArray.length; i++) {
            if (counterArray[i] > max) {
                max = counterArray[i];

            }
        }
        for (int o = 0; o < counterArray.length; o++) {
            if (counterArray[o] == max) {
                for (int i = 0; i < max; i++) {
                    System.out.print(input[o] + " ");

                }
                break;
            }
        }
    }
}
