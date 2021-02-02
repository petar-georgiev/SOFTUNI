package ForLoopLab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int quantity = Integer.parseInt(scan.nextLine());
        int value = 0;
        int sum = 0;
        for (int i = 0; i < quantity; i++) {
            value = scan.nextInt();
            sum += value;
        }
        System.out.println(sum);
    }
}
