package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = readArray(scan, "\\s+");
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] firstMatrix = readMatrix(scan, rows, cols, "\\s+");

        dimensions = readArray(scan, "\\s+");
        rows = dimensions[0];
        cols = dimensions[1];

        int[][] secondMatrix = readMatrix(scan, rows, cols, "\\s+");

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        if (areEqual)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length)
            return false;

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length)
                return false;

            for (int col = 0; col < firstArr.length; col++) {
                int firstElement = firstArr[col];
                int secondElement = secondMatrix[row][col];

                if (firstElement != secondElement)
                    return false;
            }
        }
        return true;
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
