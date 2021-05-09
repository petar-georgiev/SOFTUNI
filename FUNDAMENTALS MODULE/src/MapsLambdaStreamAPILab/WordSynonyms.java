package MapsLambdaStreamAPILab;

import java.util.*;
import java.util.stream.Collectors;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> words = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {

            String word = scan.nextLine();
            String synonym = scan.nextLine();

            List<String> allsynonym = words.get(word);
            if (allsynonym == null) {
                allsynonym = new ArrayList<>();
                words.put(word, allsynonym);
            }
            allsynonym.add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }
    }
}

