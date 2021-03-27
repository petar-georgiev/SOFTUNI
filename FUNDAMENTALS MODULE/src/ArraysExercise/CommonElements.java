package ArraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = (scan.nextLine().split(" "));
        String[] input2 = (scan.nextLine().split(" "));


        for (int i = 0; i < input2.length; i++) {

            for (int j = 0; j < input.length; j++) {

                if (input2[i].equals(input[j])) {
                    System.out.printf("%s ",input2[i]);
                }
            }
        }


    }
}
