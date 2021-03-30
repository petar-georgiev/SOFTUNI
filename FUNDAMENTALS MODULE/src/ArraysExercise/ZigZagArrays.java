package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int i = 0; i < n; i++) {

            int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int j = 0; j < input.length-1; j++) {
            secondArray[i] = input[j];
            firstArray[i] = input[j+1];
            }
        }
        for (int i = 0; i < n; i+=2) {
            int temp = 0;
            temp = secondArray[i];
            secondArray[i]=firstArray[i];
            firstArray[i]=temp;
        }
        for (int i=0; i< n; i++)
        {
            System.out.printf("%d ", firstArray[i]);
        }
        System.out.println();
        for (int j=0; j< n; j++)
        {
            System.out.printf("%d ", secondArray[j]);
        }

        }
    }
