package StreamFilesAndDirectoriesLab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String filename = "d:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file = new File(filename);

        File[] innerFiles = file.listFiles();
        for (File innerFile : innerFiles) {
            if(!innerFile.isDirectory()){
                System.out.printf("%s: [%d]%n", innerFile.getName(),innerFile.length());
            }
        }
    }
}
