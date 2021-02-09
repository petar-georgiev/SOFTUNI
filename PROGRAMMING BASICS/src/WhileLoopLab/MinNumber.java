package WhileLoopLab;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        while (true){
            String input = scan.nextLine();
            if(input.equals("Stop"))
            {

                break;
            }
            int num = Integer.parseInt(input);

            if (num<min)
            {
                min = num;

            }

        }
        System.out.println(min);
    }
}
