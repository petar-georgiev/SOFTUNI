package ArraysMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Integer> recFibo = new ArrayList<Integer>(Arrays.asList(1, 1));

        for (int i = 2; i < n; i++) {
            recFibo.add(recFibo.get(i - 1) + recFibo.get(i - 2));
        }
        System.out.println(recFibo.get(recFibo.size() - 1));
    }
}
