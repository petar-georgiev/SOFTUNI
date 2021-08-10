package StreamFilesAndDirectoriesLab;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        Set<Character> punctuations = new HashSet<>();
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('!');
        punctuations.add('?');

        while (singleByte >= 0)
        {
            char symbol = (char) singleByte;
            if (!punctuations.contains(symbol)) {
                writer.print(symbol);
            }
           singleByte = inputStream.read();
        }
        writer.close();
        inputStream.close();
    }
}
