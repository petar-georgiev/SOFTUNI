package BasicExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String passWord = "";

        for (int i = userName.length() - 1; i >= 0; i--) {
            passWord += userName.charAt(i);
        }

        String confirmPass = scanner.nextLine();

        int count = 0;
        while (!passWord.equals(confirmPass)) {
            count++;

            if (count == 4) {
                System.out.printf("User %s blocked!", userName);
                return;
            }
            System.out.println("Incorrect password. Try again.");

            confirmPass = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", userName);
    }
}


