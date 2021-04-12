package MethodsMoreExercises;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int value1 = Integer.parseInt(scan.nextLine());
        int value2 = Integer.parseInt(scan.nextLine());
        int value3 = Integer.parseInt(scan.nextLine());
        int value4 = Integer.parseInt(scan.nextLine());
        int value5 = Integer.parseInt(scan.nextLine());
        int value6 = Integer.parseInt(scan.nextLine());
        int value7 = Integer.parseInt(scan.nextLine());
        int value8 = Integer.parseInt(scan.nextLine());

        printResult(value1,value2,value3,value4,value5,value6,value7,value8);

    }

    public static double getLongerLine(int x1, int y1, int x2, int y2) {
        double firstSide = x2 - x1;
        double secondSide = y2 - y1;
        double distance = Math.sqrt((Math.pow(firstSide, 2) + Math.pow(secondSide, 2)));
        return distance;
    }

    public static double getClosestPoint(int x, int y) {
        double distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        return distance;
    }
    public static void printResult(int value1, int value2, int value3, int value4, int value5, int value6, int value7, int value8){

        double firstDistance = getLongerLine(value1, value2, value3, value4);
        double secondDistance = getLongerLine(value5, value6, value7, value8);

        if (firstDistance > secondDistance) {
            if (getClosestPoint(value1, value2) < getClosestPoint(value3, value4)) {
                System.out.printf("(%d, %d)(%d, %d)", value1, value2, value3, value4);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", value3, value4, value1, value2);
            }
        } else if (firstDistance < secondDistance) {
            if (getClosestPoint(value5, value6) < getClosestPoint(value7, value8)) {
                System.out.printf("(%d, %d)(%d, %d)", value5, value6, value7, value8);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", value7, value8, value5, value6);
            }
        } else {
            System.out.printf("(%d, %d)", value1, value2);
        }
    }
}
