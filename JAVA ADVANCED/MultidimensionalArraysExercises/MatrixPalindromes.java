package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split(" ");
        int rows = Integer.parseInt(arr[0]);
        int cols = Integer.parseInt(arr[1]);

        String[][] matrix = createMatrix(rows, cols);
        printMatrix(matrix);
    }

    private static String[][] createMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        char currentChar = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "" + currentChar + (char) (currentChar + col) + currentChar;
                matrix[row][col] = palindrome;
            }
            currentChar++;
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
