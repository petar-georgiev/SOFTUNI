package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] squareMatrix = readSquareMatrix(scan, n);

        int row = 0;
        int col = 0;

        while (row < n && col < n) {
            System.out.print(squareMatrix[row++][col++] + " ");
        }
        System.out.println();
        row = n - 1;
        col = 0;
        while (row >= 0 && col < n) {
            System.out.print(squareMatrix[row--][col++] + " ");
        }
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
