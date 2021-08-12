package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt"));

        String input = reader.readLine();
        long vowelsCounter = 0;
        long consonantsCounter = 0;
        long punctuationCounter = 0;
        String vowel = "aeiou";
        String punctuation = "!.,?";

        while (input != null) {

            for (int i = 0; i < input.length(); i++) {

                if (input.charAt(i) == 32) {
                } else if (vowel.contains(String.valueOf(input.charAt(i)))) {
                    vowelsCounter++;
                } else if (punctuation.contains(String.valueOf(input.charAt(i)))) {
                    punctuationCounter++;
                } else {
                    consonantsCounter++;
                }
            }

            input = reader.readLine();
        }
        writer.write("Vowels: " + vowelsCounter);
        writer.newLine();
        writer.write("Consonants: " + consonantsCounter);
        writer.newLine();
        writer.write("Punctuation: " + punctuationCounter);

        writer.close();
    }
}
