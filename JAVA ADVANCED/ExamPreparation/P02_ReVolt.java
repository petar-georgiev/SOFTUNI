package ExamPreparation;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P02_ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dim = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        char matrix[][] = new char[dim][dim];

        readMatrix(scan, matrix);

        int[] positionOfPlayer = findPlayer(matrix);

        while (n-- >= 0) {
            String operation = scan.nextLine();

            int[] oldPositionOfPlayer = new int[]{positionOfPlayer[0], positionOfPlayer[1]};
            int oldRow = oldPositionOfPlayer[0];
            int oldCol = oldPositionOfPlayer[1];

            switch (operation) {
                case "up":
                    positionOfPlayer[0] -= 1;
                    try {
                        char option = matrix[positionOfPlayer[0]][positionOfPlayer[1]];
                        switch (option) {
                            case 'B':
                                try {
                                    positionOfPlayer[0] -= 1;
                                    matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'B';
                                } catch (ArrayIndexOutOfBoundsException ex) {
                                    positionOfPlayer[0] += matrix[0].length;
                                    matrix[oldRow][oldCol] = '-';
                                    matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
                                }
                                break;
                            case 'T':
                                try {
                                    positionOfPlayer[0] += 1;
                                    matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'T';
                                } catch (ArrayIndexOutOfBoundsException ex) {
                                    positionOfPlayer = new int[]{oldPositionOfPlayer[0], positionOfPlayer[1]};
                                }
                                break;
                            case 'F':
                                matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
                                System.out.println("Player won!");
                                printMatrix(matrix);
                                return;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        positionOfPlayer[0] += matrix[0].length;
                        matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
                        matrix[oldRow][oldCol] = '-';
                    }
                    break;

//                case "down":
//                    positionOfPlayer[0] += 1;
//                    option = matrix[positionOfPlayer[0]][positionOfPlayer[1]];
//                    switch (option) {
//                        case 'B':
//                            positionOfPlayer[0] += 1;
//                            break;
//                        case 'T':
//                            positionOfPlayer[0] -= 1;
//                            break;
//                        case 'F':
//                            matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
//                            printMatrix(matrix);
//                            return;
//                    }
//                    matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
//                    System.out.println("Player won!");
//                    matrix[oldRow][oldCol] = '-';
//                    break;
//
//
//                case "right":
//                    positionOfPlayer[1] += 1;
//                    option = matrix[positionOfPlayer[0]][positionOfPlayer[1]];
//                    switch (option) {
//                        case 'B':
//                            positionOfPlayer[1] += 1;
//                            break;
//                        case 'T':
//                            positionOfPlayer[1] -= 1;
//                            break;
//                        case 'F':
//                            matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
//                            System.out.println("Player won!");
//                            printMatrix(matrix);
//                            return;
//                    }
//                    matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
//                    matrix[oldRow][oldCol] = '-';
//                    break;
//
//
//                case "left":
//                    positionOfPlayer[1] -= 1;
//                    option = matrix[positionOfPlayer[0]][positionOfPlayer[1]];
//                    switch (option) {
//                        case 'B':
//                            positionOfPlayer[1] -= 1;
//                            break;
//                        case 'T':
//                            positionOfPlayer[1] += 1;
//                            break;
//                        case 'F':
//                            matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
//                            System.out.println("Player won!");
//                            printMatrix(matrix);
//                            return;
//                    }
//                    matrix[positionOfPlayer[0]][positionOfPlayer[1]] = 'f';
//                    matrix[oldRow][oldCol] = '-';
//                    break;
            }
        }
        System.out.println("Player lost!");
        printMatrix(matrix);
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

    private static int[] findPlayer(char[][] matrix) {
        int[] positionOfPlayer = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
                    positionOfPlayer[0] = row;
                    positionOfPlayer[1] = col;
                }
            }
        }
        return positionOfPlayer;
    }


}
