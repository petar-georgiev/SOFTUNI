package StreamFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        int singleByte = inputStream.read();
        while (singleByte >= 0) {

            System.out.print(Integer.toBinaryString(singleByte) + " ");
            singleByte = inputStream.read();
        }
        inputStream.close();
    }
}
