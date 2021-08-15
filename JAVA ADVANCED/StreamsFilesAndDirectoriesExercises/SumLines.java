package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt"));

        String input = reader.readLine();
        while (input != null) {
            int sum = 0;

            for (int i = 0; i < input.length(); i++) {
                sum += input.charAt(i);
            }
            writer.write(String.valueOf(sum));
            writer.newLine();

            input = reader.readLine();
        }
        writer.close();
    }
}
