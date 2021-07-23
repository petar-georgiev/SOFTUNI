package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nXm = readArray(scan);
        int rows = nXm[0];
        int cols = nXm[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scan);
        }
        int maxSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int sum = calculateMatrixSum(matrix, row, col);
                if (maxSum < sum) {
                    maxSum = sum;
                    indexRow = row;
                    indexCol = row;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMaxSubMatrix(matrix, indexRow, indexCol);


    }

    private static void printMaxSubMatrix(int[][] matrix, int indexRow, int indexCol) {
        for (int row = indexRow - 1; row < indexRow + 2; row++) {
            for (int col = indexCol - 1; col < indexCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;
        sum += matrix[row][col];

        //R
        sum += matrix[row][col + 1];
        //L
        sum += matrix[row][col - 1];
        //U
        sum += matrix[row - 1][col];
        //D
        sum += matrix[row + 1][col];
        //RU
        sum += matrix[row - 1][col + 1];
        //LU
        sum += matrix[row - 1][col - 1];
        //RD
        sum += matrix[row + 1][col + 1];
        //LD
        sum += matrix[row + 1][col - 1];

        return sum;
    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
