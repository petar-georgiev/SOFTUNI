package ExamPreparation;

import java.util.Scanner;

public class P02_Selling {
    public static int money = 0;
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dim = Integer.parseInt(scan.nextLine());

        char[][] matrix = readMatrix(scan, dim);

        int[] position = findPosition(matrix);

        while (!enoughMoney(matrix)) {
            String operation = scan.nextLine();
            changePosition(matrix, position, operation);
            if (flag)
                return;
        }
    }

    private static void changePosition(char[][] matrix, int[] position, String operation) {
        int[] oldPosition = {position[0], position[1]};
        switch (operation) {
            case "up":
                position[0]--;
                if (outOfBoundary(matrix, position, oldPosition))
                    return;
                whatIsNext(matrix, position, oldPosition);
                break;

            case "down":
                position[0]++;
                if (outOfBoundary(matrix, position, oldPosition))
                    return;
                whatIsNext(matrix, position, oldPosition);
                break;

            case "left":
                position[1]--;
                if (outOfBoundary(matrix, position, oldPosition))
                    return;
                whatIsNext(matrix, position, oldPosition);
                break;

            case "right":
                position[1]++;
                if (outOfBoundary(matrix, position, oldPosition))
                    return;
                whatIsNext(matrix, position, oldPosition);
                break;
        }
    }

    private static void whatIsNext(char[][] matrix, int[] position, int[] oldPosition) {
        char currentPosition = matrix[position[0]][position[1]];
        if (currentPosition == 'O') {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (row == position[0] && col == position[1]) {
                        matrix[oldPosition[0]][oldPosition[1]] = '-';
                        matrix[row][col] = 'S';
                        oldPosition[0] = row;
                        oldPosition[1] = col;
                    } else if (matrix[row][col] == 'O') {
                        matrix[row][col] = 'S';
                        matrix[oldPosition[0]][oldPosition[1]] = '-';
                        position[0] = row;
                        position[1] = col;
                        return;
                    }
                }
            }
        } else if (Character.isDigit(currentPosition)) {
            int value = Integer.parseInt(String.valueOf(currentPosition));
            money += value;
        }
        matrix[position[0]][position[1]] = 'S';
        matrix[oldPosition[0]][oldPosition[1]] = '-';
    }

    private static boolean outOfBoundary(char[][] matrix, int[] position, int[] oldPosition) {
        if (position[0] < 0 || position[0] >= matrix.length
                || position[1] < 0 || position[1] >= matrix[0].length) {
            matrix[oldPosition[0]][oldPosition[1]] = '-';
            System.out.println("Bad news, you are out of the bakery.");
            System.out.println("Money: " + money);
            print(matrix);
            flag = true;
            return true;
        }
        return false;
    }

    private static boolean enoughMoney(char[][] matrix) {
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.println("Money: " + money);
            print(matrix);
            return true;
        }
        return false;
    }

    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
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
            String input = scan.nextLine();
            for (int col = 0; col < input.length(); col++) {
                matrix[row][col] = input.charAt(col);
            }
        }
        return matrix;
    }
}
