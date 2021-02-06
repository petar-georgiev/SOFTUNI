package ForLoopExercise;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = Integer.parseInt(scan.nextLine());;
        double p1 =0.0;
        double p2 =0.0;
        double p3 =0.0;
        double p4 =0.0;
        double p5 =0.0;
        double p11 =0.0;
        double p12 =0.0;
        double p13 =0.0;
        double p14 =0.0;
        double p15 =0.0;
        for (int i = 0; i < quantity; i++) {
            int value = scan.nextInt();
            if (value < 200) {
                p1++;
                p11 = (p1/quantity)*100;

            }
            if (value >= 200 && value<=399) {
                p2++;
                p12 = (p2/quantity)*100;
            }
            if (value >= 400 && value<=599) {
                p3++;
                p13 =  (p3/quantity)*100;
            }
            if (value >= 600 && value<=799) {
                p4++;
                p14 = (p4/quantity)*100;
            }
            if (value>=800) {
                p5++;
                p15 = (p5/quantity)*100;
            }
        }
        System.out.printf("%.2f%%%n",p11);
        System.out.printf("%.2f%%%n",p12);
        System.out.printf("%.2f%%%n",p13);
        System.out.printf("%.2f%%%n",p14);
        System.out.printf("%.2f%%%n",p15);
    }
}
