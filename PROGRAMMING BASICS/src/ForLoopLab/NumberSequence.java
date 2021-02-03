package ForLoopLab;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int quantity = Integer.parseInt(scan.nextLine());
        int value = 0;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < quantity; i++) {
            value = scan.nextInt();
            if (value < smallest) {
                smallest = value;
            }
            if (value > largest) {
                largest = value;
            }
        }
        System.out.println("Max number: " + largest);
        System.out.println("Min number: " + smallest);

    }
}
