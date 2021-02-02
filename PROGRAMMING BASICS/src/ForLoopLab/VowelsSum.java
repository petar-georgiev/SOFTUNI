package ForLoopLab;

import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int sum = 0;

        char a = 'a';
        char e = 'e';
        char i = 'i';
        char o = 'o';
        char u = 'u';

        for (int p = 0; p < word.length(); p++) {
            char vowelLetter = word.charAt(p);

            if(vowelLetter==a){
                sum+=1;
            }
            if(vowelLetter==e){
                sum+=2;
            }
            if(vowelLetter==i){
                sum+=3;
            }
            if(vowelLetter==o){
                sum+=4;
            }
            if(vowelLetter==u){
                sum+=5;
            }

        }
        System.out.println(sum);
    }
}
