package BasicExercise;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        if (a >= 0 && a <= 2) {
            System.out.println("baby");
        }
        else  if (a >= 3 && a <= 13) {
            System.out.println("child");}
        else  if (a >= 14 && a <= 19) {
            System.out.println("teenager");}
        else  if (a >= 20 && a <= 65) {
            System.out.println("adult");}
        else  if (a >= 65) {
            System.out.println("elder");}

    }
}
