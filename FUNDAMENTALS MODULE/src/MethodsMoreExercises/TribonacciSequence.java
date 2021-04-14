package MethodsMoreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());
        printTribonachi(input);

    }

    public static int getTribonachi(int input) {
     if(input==1 || input==2)
         return 1;
     if(input== 3)
         return 2;
     else return getTribonachi(input-1)+
             getTribonachi(input-2)+
             getTribonachi(input-3);
    }
    public static void printTribonachi(int input)
    {
        for (int i = 1; i <= input ; i++) {
            System.out.print(getTribonachi(i)+" ");
        }
    }
}

