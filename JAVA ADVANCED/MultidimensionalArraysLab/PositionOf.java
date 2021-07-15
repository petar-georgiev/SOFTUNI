package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pattern = "\\s+";

        int[] dimension = readArray(scan, pattern);
        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = readMatrix(scan, rows, cols, pattern);

        int n = Integer.parseInt(scan.nextLine());

        boolean isExist = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (n == matrix[row][col]) {
                    System.out.println(row + " " + col);
                    isExist = true;
                }
            }
        }
        if (!isExist) {
            System.out.println("not found");
        }
    }

    private static int[][] readMatrix(Scanner scan, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = readArray(scan, pattern);
            matrix[row] = arr;
        }
        return matrix;
    }
    private static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
