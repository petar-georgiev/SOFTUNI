package StreamFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamFilesAndDirectoriesLab\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt"), lines);
    }
}
