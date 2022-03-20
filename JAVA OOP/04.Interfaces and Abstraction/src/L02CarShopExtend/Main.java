package L02CarShopExtend;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Car seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Car audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(String.format("This is %s produced in %s and have %d tires", car.getModel(),car.countryProduced(),car.TIRES));
        System.out.println(car);

    }
}
