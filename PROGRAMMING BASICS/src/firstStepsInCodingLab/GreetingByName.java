package firstStepsInCodingLab;

import java.util.Scanner;

public class GreetingByName {
    public static void main(String arg[]) {
    Scanner scan = new Scanner(System.in);

    String name = scan.nextLine();

    System.out.printf("Hello, %s!", name);
}
}
