package GenericsExercises.P01_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0){
            String input = scan.nextLine();
            Box<String> box = new Box(input);
            System.out.println(box);
        }
    }
}
