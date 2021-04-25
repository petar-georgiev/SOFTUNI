package ObjectAndClassesLab;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = n; i >0 ; i--) {
        factorial = factorial.multiply(BigInteger.valueOf(i));

        }
        System.out.println(factorial);
    }
}
