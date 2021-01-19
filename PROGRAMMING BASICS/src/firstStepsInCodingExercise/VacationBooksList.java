package firstStepsInCodingExercise;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);


        int pages = scan.nextInt();
        int pagesForOneHour = scan.nextInt();
        int Days = scan.nextInt();

        int allTime = pages / pagesForOneHour;
        int neededHours = allTime / Days;

        System.out.println(neededHours);
    }
}
