package conditionalStatementsLab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String figureName = scan.nextLine();

        if (figureName.equals("square")) {
            double a = scan.nextDouble();

            System.out.println(Math.pow(a, 2));

        } else if (figureName.equals("rectangle")) {
            double a = scan.nextDouble();
            double b = scan.nextDouble();

            System.out.println(a * b);
        } else if (figureName.equals("circle")) {

            Double r = scan.nextDouble();

            System.out.println(Math.PI * Math.pow(r, 2));
        } else if (figureName.equals("triangle")) {
            Double a = scan.nextDouble();
            Double h = scan.nextDouble();

            System.out.println((a * h) / 2);
        }
    }
}

