package L03StudentSystem;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static Scanner scanner = new Scanner(System.in);


    public static String[] readStringArray(String delimiter) {
        return scanner.nextLine().split(delimiter);
    }
}
