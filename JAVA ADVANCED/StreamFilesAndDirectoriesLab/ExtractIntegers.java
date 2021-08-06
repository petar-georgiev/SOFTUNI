package StreamFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileWriter writer = new FileWriter("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        Scanner scan = new Scanner(inputStream);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int number = scan.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scan.next();
        }

        writer.close();
    }
}
