package ForLoopLab;

import java.util.Scanner;

public class EvenPowersOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; num >= i; i += 2) {
            System.out.println((int) (Math.pow(2, i)));
        }
    }
}
