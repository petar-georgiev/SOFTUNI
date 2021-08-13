package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(getFilePath()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath()));

       int  counter = 1;
       String currentLine = reader.readLine();
        while (currentLine != null){
            writer.write(String.format("%s. %s",counter++,currentLine));
            writer.newLine();
            currentLine = reader.readLine();
        }
        writer.close();
    }


    private static String getFilePath() {
        return "D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    }

    private static String outputFilePath() {
        return "D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt";
    }
}
