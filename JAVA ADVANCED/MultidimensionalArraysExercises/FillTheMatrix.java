package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pattern = ", ";

        String[] dimension = readLine(scan, pattern);
        int n = Integer.parseInt(dimension[0]);
        String operation = dimension[1];

        int[][] matrix = new int[n][n];
        if (operation.equals("A")) {

            int row = 0;
            int col = 0;

            int counter = 1;
            while (col < n) {
                matrix[row][col] = counter++;
                if (row == n - 1) {
                    col++;
                }
                row++;
                if (row == n) {
                    row = 0;
                }
            }
        } else {
            int row = 0;
            int col = 0;

            int counter = 1;
            while (col < n) {
                matrix[row][col] = counter++;
                if (col % 2 == 0) {
                    row++;
                    if (row == n) {
                        col++;
                        row = n - 1;
                    }
                } else {
                    row--;
                    if (row < 0) {
                        row = 0;
                        col++;
                    }
                }

            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[] readLine(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern))
                .toArray(String[]::new);
    }
}
