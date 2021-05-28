package RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> participants = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();
        String regexName = "[A-Za-z]";
        String regexDistance = "\\d";

        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(regexDistance);
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> racers = new LinkedHashMap<>();
        int finalDistance = 0;

        while (!input.equals("end of race")) {
            Matcher matcherName = patternName.matcher(input);
            Matcher matcherDistance = patternDistance.matcher(input);

            while (matcherName.find()) {
                sb.append(matcherName.group());
            }

            if (participants.contains(sb.toString())) {
                if (!racers.containsKey(sb.toString())) {
                    while (matcherDistance.find()) {
                        int distance = Integer.parseInt(matcherDistance.group());
                        finalDistance += distance;
                    }
                    racers.put(sb.toString(), finalDistance);
                } else {
                    int moreDistance = racers.get(sb.toString());
                    while (matcherDistance.find()) {
                        int distance = Integer.parseInt(matcherDistance.group());
                        finalDistance += distance;
                    }
                    racers.put(sb.toString(), finalDistance + moreDistance);
                }
            }
            input = scan.nextLine();
            sb = new StringBuilder();
            finalDistance = 0;
        }
        List<String> finishers = racers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (int i = 0; i < finishers.size(); i++) {
            if (i == 0)
                System.out.printf("%dst place: %s%n", i + 1, finishers.get(i));
            else if (i == 1)
                System.out.printf("%dnd place: %s%n", i + 1, finishers.get(i));
            else
                System.out.printf("%drd place: %s%n", i + 1, finishers.get(i));
        }
    }
}
