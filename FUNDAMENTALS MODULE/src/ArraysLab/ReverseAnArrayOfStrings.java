package ArraysLab;

import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = (scan.nextLine().split(" "));
        for (int i = array.length - 1; i > -1; i--) {
            System.out.print(array[i] + " ");

        }
    }
}
