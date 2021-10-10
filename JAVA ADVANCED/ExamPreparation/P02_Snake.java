package ExamPreparation;

import java.util.Scanner;

public class P02_Snake {

    public static int food = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int dim = Integer.parseInt(scan.nextLine());


        char[][] matrix = new char[dim][dim];

        readMatrix(scan, matrix);

        int[] positionOfSnake = findSnake(matrix);

        while (food < 10) {
            String operation = scan.nextLine();

            int[] oldPositionOfSnake = new int[]{positionOfSnake[0], positionOfSnake[1]};


            switch (operation) {
                case "up":
                    positionOfSnake[0] -= 1;
                    if (hasFinished(matrix, positionOfSnake, oldPositionOfSnake[0], oldPositionOfSnake[1])) {
                        return;
                    }
                    moveSnake(matrix, positionOfSnake, oldPositionOfSnake);
                    break;

                case "down":
                    positionOfSnake[0] += 1;
                    if (hasFinished(matrix, positionOfSnake, oldPositionOfSnake[0], oldPositionOfSnake[1])) {
                        return;
                    }
                    moveSnake(matrix, positionOfSnake, oldPositionOfSnake);
                    break;


                case "right":
                    positionOfSnake[1] += 1;
                    if (hasFinished(matrix, positionOfSnake, oldPositionOfSnake[0], oldPositionOfSnake[1])) {
                        return;
                    }
                    moveSnake(matrix, positionOfSnake, oldPositionOfSnake);
                    break;


                case "left":
                    positionOfSnake[1] -= 1;
                    if (hasFinished(matrix, positionOfSnake, oldPositionOfSnake[0], oldPositionOfSnake[1])) {
                        return;
                    }
                    moveSnake(matrix, positionOfSnake, oldPositionOfSnake);
                    break;
            }
        }
        System.out.println("You won! You fed the snake.");
        System.out.println("Food eaten: " + food);
        printMatrix(matrix);
    }

    private static void moveSnake(char[][] matrix, int[] positionOfSnake, int[] oldPositionOfSnake) {

        int oldRow = oldPositionOfSnake[0];
        int oldCol = oldPositionOfSnake[1];
        int newRow = positionOfSnake[0];
        int newCol = positionOfSnake[1];

        if (matrix[newRow][newCol] == '*') {
            food++;
        } else if (matrix[newRow][newCol] == 'B') {
            if (findBonus(matrix, positionOfSnake)) {
                matrix[oldRow][oldCol] = '.';
                return;
            }
        }
        matrix[newRow][newCol] = 'S';
        matrix[oldRow][oldCol] = '.';

    }

    private static boolean findBonus(char[][] matrix, int[] positionOfSnake) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == positionOfSnake[0] && col == positionOfSnake[1]) {
                    matrix[row][col] = '.';
                } else if (matrix[row][col] == 'B') {
                    positionOfSnake[0] = row;
                    positionOfSnake[1] = col;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasFinished(char[][] matrix, int[] positionOfSnake, int oldRow, int oldCol) {
        if (positionOfSnake[0] < 0 || positionOfSnake[1] < 0
                || positionOfSnake[0] >= matrix.length || positionOfSnake[1] >= matrix[0].length) {
            matrix[oldRow][oldCol] = '.';
            System.out.println("Game over!");
            System.out.println("Food eaten: " + food);
            printMatrix(matrix);
            return true;
        }
        return false;
    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner scan, char[][] matrix) {
        String line = scan.nextLine();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line.charAt(col);
            }
            if (row < matrix.length - 1)
                line = scan.nextLine();
        }
    }

    private static int[] findSnake(char[][] matrix) {
        int[] positionOfSnake = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    positionOfSnake[0] = row;
                    positionOfSnake[1] = col;
                }
            }
        }
        return positionOfSnake;
    }
}
