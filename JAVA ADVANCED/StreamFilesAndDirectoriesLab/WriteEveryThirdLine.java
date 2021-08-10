package StreamFilesAndDirectoriesLab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt"));

        String line = reader.readLine();
        int lineNumber = 1;

        while (line != null) {
            lineNumber++;

            line = reader.readLine();

            if (lineNumber % 3 == 0) {
                writer.write(line);
                writer.newLine();
             }
        }
        writer.close();
    }
}
