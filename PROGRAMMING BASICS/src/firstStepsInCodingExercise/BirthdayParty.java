package firstStepsInCodingExercise;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        int rent = scan.nextInt();

        double cake = rent * 0.2;
        double drinks = cake - (cake * 0.45);
        double animator = rent / 3.0;
        System.out.println(rent + cake + drinks + animator);
    }
}
