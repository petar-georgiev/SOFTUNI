package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        readMatrix(scan, rows, firstMatrix);
        readMatrix(scan, rows, secondMatrix);

        printIntersectionMatrix(rows, cols, firstMatrix, secondMatrix);

    }

    private static void printIntersectionMatrix(int rows, int cols, String[][] firstMatrix, String[][] secondMatrix) {
        for (int row = 0; row < rows; row++) {
            String[] currentArr = intersectMatrix(rows, cols, firstMatrix, secondMatrix)[row];
            for (String s : currentArr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String[][] intersectMatrix(int rows, int cols, String[][] firstMatrix, String[][] secondMatrix) {
        String[][] thirdMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    thirdMatrix[row][col] = "*";
                } else {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                }
            }
        }
        return thirdMatrix;
    }

    private static void readMatrix(Scanner scan, int rows, String[][] firstMatrix) {
        for (int row = 0; row < rows; row++) {
            String[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .toArray(String[]::new);
            firstMatrix[row] = arr;

        }
    }
}