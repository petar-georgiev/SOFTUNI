package WhileLoopExercise;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String book = scan.nextLine();
        int i = 0;
        boolean isFound = false;
        String input = scan.nextLine();
        while (!input.equals("No More Books")) {
            if (input.equals(book)) {
                isFound = true;
                break;
            }
            i++;
            input = scan.nextLine();
        }

        if (isFound) {
            System.out.printf("You checked %d books and found it.", i);
        } else {

            System.out.printf("The book you search is not here!%nYou checked %d books.", i);
        }
    }
}
