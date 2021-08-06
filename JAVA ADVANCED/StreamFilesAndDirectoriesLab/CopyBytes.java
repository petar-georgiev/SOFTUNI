package StreamFilesAndDirectoriesLab;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        while (singleByte >= 0) {
            if (singleByte == 10 || singleByte == 32) {
                writer.print((char) singleByte);
            } else {
                writer.print(singleByte);
            }
            singleByte = inputStream.read();
        }
        writer.close();
        inputStream.close();
    }
}
