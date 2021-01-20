package conditionalStatementsExercise;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int timeFirst = scan.nextInt();
        int timeSecond = scan.nextInt();
        int timeThird = scan.nextInt();

        int totalTime = timeFirst + timeSecond + timeThird;

        int minutes = totalTime / 60;
        int second = totalTime % 60;

        if (second < 10) {
            System.out.printf("%d:0%d", minutes, second);
        } else {
            System.out.printf("%d:%d", minutes, second);
        }
    }
}

