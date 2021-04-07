package MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());

        String result = repeatString(input,n);
        System.out.println(result);
    }
    public static String repeatString(String str, int count){
        String result = "";
        for (int i = 0; i < count; i++) {
        result+=str;

        }
        return result;
    }
}
