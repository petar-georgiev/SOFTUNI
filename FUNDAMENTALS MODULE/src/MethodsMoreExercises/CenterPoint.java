package MethodsMoreExercises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

    int a = Integer.parseInt(scan.nextLine());
    int b = Integer.parseInt(scan.nextLine());
    int c = Integer.parseInt(scan.nextLine());
    int d = Integer.parseInt(scan.nextLine());


    if(getClosestPoint(a,b)<getClosestPoint(c,d)){
        System.out.printf("(%d, %d)",a,b);
    }else {
        System.out.printf("(%d, %d)",c,d);
    }

    }
    public static double getClosestPoint (int a, int b){
        double distance = Math.sqrt((Math.pow(a,2)+Math.pow(b,2)));
    return distance;
    }
}
