package firstStepsInCodingLab;

import java.util.Scanner;

public class InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double inches = Double.parseDouble(scan.nextLine());
        double centimeter = inches * 2.54;
        System.out.println(centimeter);
    }
}
