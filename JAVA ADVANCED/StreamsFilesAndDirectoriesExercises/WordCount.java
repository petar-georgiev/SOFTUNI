package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader readFirstFile = new BufferedReader(firstFile());
        BufferedReader readSecondFile = new BufferedReader(secondFile());


        Set<String> words = readFirstFile.lines().map(l -> l.split("\\s+"))
                .flatMap(Arrays::stream).collect(Collectors.toSet());
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.putIfAbsent(word, 0);
        }

        String line = readSecondFile.readLine();

        while (line != null) {

            String[] text = line.split("\\s+");

            for (String word : text) {
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                }
            }


            line = readSecondFile.readLine();
        }
        wordCountMap.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));


    }


    private static FileReader firstFile() throws FileNotFoundException {
        return new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
    }

    private static FileReader secondFile() throws FileNotFoundException {
        return new FileReader("D:\\SOFTUNI\\JAVA ADVANCED\\src\\StreamsFilesAndDirectoriesExercises\\RESOURCES\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
    }
}
