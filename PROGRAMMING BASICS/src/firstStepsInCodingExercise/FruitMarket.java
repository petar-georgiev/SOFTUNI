package firstStepsInCodingExercise;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        double qgodiCena = scan.nextDouble();
        double banani = scan.nextDouble();
        double portokali = scan.nextDouble();
        double malini = scan.nextDouble();
        double qgodi = scan.nextDouble();

        double maliniCena = qgodiCena - (qgodiCena * 0.5);
        double potokaliCena = maliniCena - (maliniCena * 0.4);
        double bananiCena = maliniCena - (maliniCena * 0.8);

        double maliniSum = malini * maliniCena;
        double bananiSum = banani * bananiCena;
        double qgodiSum = qgodi * qgodiCena;
        double portokaliSum = portokali * potokaliCena;
        double allSum = maliniSum + bananiSum + qgodiSum + portokaliSum;
        System.out.printf("%.2f", allSum);
    }
}
