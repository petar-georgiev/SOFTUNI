package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {


        PrintWriter writer = new PrintWriter("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt");

        File folder = new File("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        File[] files = folder.listFiles();
        int size = 0;
        if(files != null){
            for (File file : files) {
                size+=file.length();
            }
        }
        writer.printf("Folder size: %d", size);
        writer.close();
    }
}