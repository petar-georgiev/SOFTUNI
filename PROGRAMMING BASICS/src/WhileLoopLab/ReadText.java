package WhileLoopLab;

import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();

        while (!a.equals("Stop")) {
            System.out.println(a);
            a = scan.nextLine();
        }
    }
}
