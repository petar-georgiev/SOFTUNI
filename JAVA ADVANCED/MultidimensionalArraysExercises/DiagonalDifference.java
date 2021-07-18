package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] squareMatrix = readSquareMatrix(scan, n);

        int sumFirst = 0;
        int sumSecond = 0;

        int row = 0;
        int col = 0;
        while (row < n && col < n) {
            sumFirst += squareMatrix[row][col];
            row++;
            col++;
        }

        row = n - 1;
        col = 0;
        while (row >= 0 && col < n) {
            sumSecond += squareMatrix[row][col];
            row--;
            col++;
        }
        System.out.println(Math.abs(sumFirst - sumSecond));
    }

    private static int[][] readSquareMatrix(Scanner scan, int n) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
        return matrix;
    }
}

