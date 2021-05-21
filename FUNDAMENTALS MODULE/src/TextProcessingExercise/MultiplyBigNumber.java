package TextProcessingExercise;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNumber = scan.nextLine();
        int number = Integer.parseInt(scan.nextLine());
        if (number == 0) {
            System.out.println(0);
            return;
        }
        while (bigNumber.charAt(0) == '0') {
            bigNumber = bigNumber.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        int reminder = 0;

        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int result = digit * number + reminder;
            reminder = 0;
            if (result > 9) {
                reminder = result / 10;
                result = result % 10;
            }
            sb.append(result);
        }
        if (reminder != 0) {
            sb.append(reminder);
        }
        System.out.println(sb.reverse().toString());
    }
}
