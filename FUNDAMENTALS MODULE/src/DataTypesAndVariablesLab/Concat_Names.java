package DataTypesAndVariablesLab;

import java.util.Scanner;

public class Concat_Names {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String family = scan.nextLine();
        String symbols = scan.nextLine();

        System.out.printf("%s%s%s",name,symbols,family);
    }
}
