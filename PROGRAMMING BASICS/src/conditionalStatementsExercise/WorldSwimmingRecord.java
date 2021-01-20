package conditionalStatementsExercise;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timePerMeter = Double.parseDouble(scan.nextLine());

        double swimTime = distance * timePerMeter;
        double addResistance = Math.floor((distance / 15)) * 12.5;
        double swimAllTime = swimTime + addResistance;

        if (swimAllTime < record) {

            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", swimAllTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", swimAllTime - record);
        }
    }
}
