package ForLoopLab;

import java.util.Scanner;

public class Numbers1ToNStepsThree {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= num; i += 3) {
            System.out.println(i);
        }
    }
}
