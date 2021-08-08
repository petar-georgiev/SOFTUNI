package StreamFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;

public class NestedFolders {
    public static int foldersCount = 1;

    public static void main(String[] args) throws IOException {

        String filename = "d:\\SOFTUNI\\JAVA ADVANCED\\" +
                "src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        File file = new File(filename);

        File[] innerFiles = file.listFiles();
        dfs(file);
        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file) {

        foldersCount++;
        for (File f : file.listFiles()) {
            if(f.isDirectory()){
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
