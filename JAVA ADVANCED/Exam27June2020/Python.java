package Exam27June2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {

    public static int length = 0;
    public static boolean flag = false;
    public static boolean enemyFlag = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dim = Integer.parseInt(scan.nextLine());
        List<String> operationList = Arrays.stream(scan.nextLine().split(", "))
                .map(String::valueOf).collect(Collectors.toList());

        char[][] matrix = readMatrix(scan, dim);

        int[] position = findPosition(matrix);
        int food = findAllFoods(matrix);


        for (String option : operationList) {
            String operation = option;
            changePosition(matrix, position, operation);
            if (isFoodEaten(food) || enemyFlag) {
                return;
            }

        }
        System.out.println(String.format("You lose! There is still %d food to be eaten.", food - length));

    }


    private static boolean isFoodEaten(int food) {
        if (food == length) {
            System.out.println(String.format("You win! Final python length is %d", length + 1));
            return true;
        }
        return false;
    }

    private static int findAllFoods(char[][] matrix) {
        int food = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
                    food++;
                }
            }
        }
        return food;
    }

    private static void changePosition(char[][] matrix, int[] position, String operation) {
        int[] oldPosition = {position[0], position[1]};
        switch (operation) {
            case "up":
                int currentPosition = --position[0];

                if (currentPosition < 0) {
                    position[0] = matrix.length - 1;
                    whatIsNext(matrix, position, oldPosition);
                    matrix[oldPosition[0]][oldPosition[1]] = '*';
                    matrix[position[0]][position[1]] = 's';


                } else {
                    whatIsNext(matrix, position, oldPosition);
                }
                break;

            case "down":
                currentPosition = ++position[0];

                if (currentPosition == matrix.length) {
                    position[0] = 0;
                    whatIsNext(matrix, position, oldPosition);
                    matrix[oldPosition[0]][oldPosition[1]] = '*';
                    matrix[position[0]][position[1]] = 's';

                } else {
                    whatIsNext(matrix, position, oldPosition);
                }
                break;

            case "left":
                currentPosition = --position[1];

                if (currentPosition < 0) {
                    position[1] = matrix[0].length - 1;
                    whatIsNext(matrix, position, oldPosition);
                    matrix[oldPosition[0]][oldPosition[1]] = '*';
                    matrix[position[0]][position[1]] = 's';

                } else {
                    whatIsNext(matrix, position, oldPosition);
                }
                break;

            case "right":
                currentPosition = ++position[1];

                if (currentPosition == matrix[0].length) {
                    position[1] = 0;
                    whatIsNext(matrix, position, oldPosition);
                    matrix[oldPosition[0]][oldPosition[1]] = '*';
                    matrix[position[0]][position[1]] = 's';

                } else {
                    whatIsNext(matrix, position, oldPosition);
                }
                break;
        }
    }

    private static void whatIsNext(char[][] matrix, int[] position, int[] oldPosition) {
        char currentPosition = matrix[position[0]][position[1]];
        if (currentPosition == 'f') {
            length++;
        } else if (currentPosition == 'e') {
            matrix[position[0]][position[1]] = 's';
            matrix[oldPosition[0]][oldPosition[1]] = '*';
            enemyFlag = true;
            System.out.println("You lose! Killed by an enemy!");
            return;
        }
        matrix[position[0]][position[1]] = 's';
        matrix[oldPosition[0]][oldPosition[1]] = '*';
    }


    private static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }

    private static char[][] readMatrix(Scanner scan, int dim) {
        char[][] matrix = new char[dim][dim];
        for (int row = 0; row < dim; row++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int col = 0; col < input.length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
        return matrix;
    }
}
