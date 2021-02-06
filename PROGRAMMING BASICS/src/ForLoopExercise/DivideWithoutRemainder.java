package ForLoopExercise;

import java.util.Scanner;

public class DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = Integer.parseInt(scan.nextLine());;

        double p1 =0.0;
        double p2 =0.0;
        double p3 =0.0;
        double p11 =0.0;
        double p12 =0.0;
        double p13 =0.0;

        for (int i = 0; i < quantity; i++) {
            int value = scan.nextInt();
            if (value%2==0) {
                p1++;
                p11 = (p1/quantity)*100;

            }
            if (value%3==0) {
                p2++;
                p12 = (p2/quantity)*100;
            }
            if (value%4==0) {
                p3++;
                p13 =  (p3/quantity)*100;
            }


        }

        System.out.printf("%.2f%%%n",p11);
        System.out.printf("%.2f%%%n",p12);
        System.out.printf("%.2f%%%n",p13);
    }
}
