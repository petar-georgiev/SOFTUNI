package DefiningClassesLab.P01_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car(brand, model, horsePower);
            System.out.println(car);
        }
    }
}
