package GenericsExercises.P02_GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            Integer input = Integer.parseInt(scan.nextLine());
            Box<Integer> box = new Box(input);
            System.out.println(box);
        }
    }
}
