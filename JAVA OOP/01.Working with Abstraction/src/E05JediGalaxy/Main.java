package E05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPositions(scanner.nextLine());
        int n = dimensions[0];
        int m = dimensions[1];

        int[][] matrix = new int[n][m];

        fillMatrix(n, m, matrix);

        String positions = scanner.nextLine();
        long sum = 0;
        while (!positions.equals("Let the Force be with you")) {
            int[] jediPosition = readPositions(positions);
            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

            int[] evilPosition = readPositions(scanner.nextLine());
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (isInRange(matrix, evilRow, evilCol)) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }


            while (jediRow >= 0 && jediCol < matrix[1].length) {
                if (isInRange(matrix, jediRow, jediCol)) {
                    sum += matrix[jediRow][jediCol];
                }

                jediCol++;
                jediRow--;
            }
            positions = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static int[] readPositions(String positions) {
        return Arrays.stream(positions.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isInRange(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void fillMatrix(int n, int m, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
