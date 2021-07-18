package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");

        }
        String input = scan.nextLine();
        while (!input.equals("END")) {

            try {
                String[] inputArr = input.split("\\s+");
                if (!inputArr[0].equalsIgnoreCase("swap") || inputArr.length > 5) {
                    throw new IllegalStateException();
                }
                int indexRowFirst = Integer.parseInt(inputArr[1]);
                int indexColFirst = Integer.parseInt(inputArr[2]);
                int indexRowSecond = Integer.parseInt(inputArr[3]);
                int indexColSecond = Integer.parseInt(inputArr[4]);

                String currentElem = matrix[indexRowFirst][indexColFirst];
                matrix[indexRowFirst][indexColFirst] = matrix[indexRowSecond][indexColSecond];
                matrix[indexRowSecond][indexColSecond] = currentElem;

                printMatrix(matrix);

            } catch (IndexOutOfBoundsException | IllegalStateException ex) {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
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

