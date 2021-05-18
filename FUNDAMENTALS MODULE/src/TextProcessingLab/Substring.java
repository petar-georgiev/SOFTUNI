package TextProcessingLab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String key = scan.nextLine();
        String text = scan.nextLine();

         while (text.contains(key)){
             text=text.replace(key,"");
         }
        System.out.println(text);
    }
}
