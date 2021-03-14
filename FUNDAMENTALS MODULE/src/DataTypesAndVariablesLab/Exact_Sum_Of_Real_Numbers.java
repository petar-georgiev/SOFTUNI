package DataTypesAndVariablesLab;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exact_Sum_Of_Real_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum =new BigDecimal("0");
        for (int i = 0; i < n; i++) {
            BigDecimal value = scan.nextBigDecimal();
            sum = sum.add(value);

        }
        System.out.println(sum);
    }
}
