package DataTypesAndVariablesLab;

import java.util.Scanner;

public class Refactor_Special_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int digit = 0;

        for (int i = 1; i <= n; i++) {
            digit = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11))
            {
                System.out.printf("%d -> True%n", digit);
            }else{
                System.out.printf("%d -> False%n", digit);
            }
            sum = 0;
            i = digit;
        }

    }

}
