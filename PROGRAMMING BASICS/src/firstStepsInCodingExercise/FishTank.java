package firstStepsInCodingExercise;

import java.util.Scanner;

public class FishTank {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        int lenght = scan.nextInt();
        int width = scan.nextInt();
        int height = scan.nextInt();
        double percentage = scan.nextDouble();

        int volumeOfTank = lenght*width*height;
        double otherThings = volumeOfTank-(volumeOfTank*percentage/100);

        double needWater = otherThings/1000;
        System.out.printf("%.2f", needWater);

    }
}

