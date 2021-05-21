package TextProcessingExercise;

import TextProcessingLab.Substring;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int fileInd = input.lastIndexOf('\\');
        int extInd = input.lastIndexOf('.');

        String file = input.substring(fileInd+1, extInd);
        String ext = input.substring(extInd+1);


        System.out.println("File name: "+file);
        System.out.println("File extension: "+ext);
    }
}
