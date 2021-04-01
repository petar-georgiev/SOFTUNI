package MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int area = getArea(a, b);
        System.out.println(area);


    }

    public static int getArea(int width, int height) {
        int sum = width * height;
        return sum;

    }
}
