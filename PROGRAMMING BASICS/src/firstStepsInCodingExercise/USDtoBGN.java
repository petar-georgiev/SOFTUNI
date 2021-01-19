package firstStepsInCodingExercise;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double USD = scan.nextDouble();
        double BGN = USD * 1.79549;
        System.out.println(BGN);
    }
}
