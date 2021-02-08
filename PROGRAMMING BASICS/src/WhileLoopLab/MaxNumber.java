package WhileLoopLab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        while (true){
            String input = scan.nextLine();
            if(input.equals("Stop"))
            {

                break;
            }
            int num = Integer.parseInt(input);

            if (num>max)
            {
                max = num;

            }

        }
        System.out.println(max);
    }
}
