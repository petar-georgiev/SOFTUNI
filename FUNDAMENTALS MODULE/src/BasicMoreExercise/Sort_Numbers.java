package BasicMoreExercise;

import java.util.Scanner;

public class Sort_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int container1 = Integer.MIN_VALUE;
        int container2 = Integer.MIN_VALUE;
        int container3 = Integer.MIN_VALUE;


        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number > container1) {
                container3=container2;
                container2=container1;
                container1=number;
            }else if(number>container2){
                container3=container2;
                container2=number;
            }else if(number>container3){
                container3=number;

            }
        }
        System.out.println(container1);
        System.out.println(container2);
        System.out.println(container3);
    }
}
