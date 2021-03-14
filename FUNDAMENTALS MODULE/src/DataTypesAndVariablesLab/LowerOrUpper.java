package DataTypesAndVariablesLab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char c = scan.next().charAt(0);
        if(c>=65&&c<=90){
            System.out.println("upper-case");
                    }
        else if(c>=97&&c<=122){
            System.out.println("lower-case");
        }
    }
}
