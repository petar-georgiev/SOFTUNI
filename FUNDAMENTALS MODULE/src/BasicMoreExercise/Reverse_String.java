package BasicMoreExercise;

import java.util.Scanner;

public class Reverse_String {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        for (int i = input.length()-1; i > -1 ; i--) {
            System.out.print(input.charAt(i));
        }
    }
}
