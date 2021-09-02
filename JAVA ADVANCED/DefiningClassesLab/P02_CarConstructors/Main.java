package DefiningClassesLab.P02_CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Car car;
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (tokens.length == 1) {
                String brand = tokens[0];
                car = new Car(brand);
            } else {
                String brand = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, horsePower);
            }
            System.out.println(car);
        }
    }
}
