package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader readFirstFile = new BufferedReader(firstFile());
        BufferedReader readSecondFile = new BufferedReader(secondFile());

        BufferedWriter writer = new BufferedWriter(getOut());

        extractedToThirdFile(readFirstFile, writer);
        extractedToThirdFile(readSecondFile, writer);

        writer.close();
    }

    private static void extractedToThirdFile(BufferedReader readFile, BufferedWriter writer) throws IOException {
        String input = readFile.readLine();
        while (input != null) {
            writer.write(input + System.lineSeparator());
            input = readFile.readLine();
        }
    }

    private static FileReader firstFile() throws FileNotFoundException {
        return new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
    }

    private static FileReader secondFile() throws FileNotFoundException {
        return new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
    }

    private static FileWriter getOut() throws IOException {
        return new FileWriter("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt");
    }
}
