package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Integer_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int fourth = Integer.parseInt(scan.nextLine());

        int output = 0;
        output = first + second;
        output = output / third;
        output = output * fourth;
        System.out.println(output);
    }
}
