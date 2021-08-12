package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt"));

        String input = reader.readLine();

        while (input != null) {

            for (int i = 0; i < input.length(); i++) {

                writer.write(String.valueOf(input.charAt(i)).toUpperCase());
            }
            writer.newLine();
            input = reader.readLine();
        }
        writer.close();
    }
}
