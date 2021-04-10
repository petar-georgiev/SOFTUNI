package MethodsExercise;

import java.util.Scanner;

public class NxNMatrix { public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int value = Integer.parseInt(scan.nextLine());
    printMatrix(value);


}
    public static void printMatrix (int a){
        for (int i = 0; i < a; i++) {
            getRowOfMatrix(a);
            System.out.println();

        }
    }
    public static void getRowOfMatrix (int a){
        for (int i = 0; i < a; i++) {
            System.out.print(a + " ");
        }
    }
}
