package ForLoopExercise;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String face = "Facebook";
        String insta = "Instagram";
        String red = "Reddit";
        int n = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n ; i++) {
            String value = scan.nextLine();


            {
                if(value.equals(face)){
                    salary-=150;
                }
                if(value.equals(insta)){
                    salary-=100;
                }
                if(value.equals(red)){
                    salary-=50;
                }
            }
        }
        if(salary<=0)
        {
            System.out.println("You have lost your salary." );

        }else {
            System.out.println(salary);
        }
    }
}
