package ExamFInal;

import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, List<Integer>> peopleMap = new TreeMap<>();

        while (!input.equals("Results")) {

            String[] tokens = input.split("\\:");
            switch (tokens[0]) {
                case "Add":
                    if (peopleMap.containsKey(tokens[1])) {
                        peopleMap.get(tokens[1]).set(0, Integer.parseInt(tokens[2])
                                + peopleMap.get(tokens[1]).get(0));
                    } else {
                        peopleMap.putIfAbsent(tokens[1], new LinkedList<>());
                        peopleMap.get(tokens[1]).add(Integer.parseInt(tokens[2]));
                        peopleMap.get(tokens[1]).add(Integer.parseInt(tokens[3]));
                    }
                    break;
                case "Attack":
                    if (peopleMap.containsKey(tokens[1]) && peopleMap.containsKey(tokens[2])) {
                        peopleMap.get(tokens[2]).set(0, peopleMap.get(tokens[2]).get(0) -
                                Integer.parseInt(tokens[3]));
                        if (peopleMap.get(tokens[2]).get(0) <= 0) {
                            peopleMap.remove(tokens[2]);
                            System.out.printf("%s was disqualified!%n", tokens[2]);
                        }
                        peopleMap.get(tokens[1]).set(1, peopleMap.get(tokens[1]).get(1) - 1);
                        if (peopleMap.get(tokens[1]).get(1) == 0) {
                            peopleMap.remove(tokens[1]);
                            System.out.printf("%s was disqualified!%n", tokens[1]);
                        }
                    }
                    break;
                case "Delete":
                    if (tokens[1].equals("All"))
                        peopleMap.clear();
                    else
                        peopleMap.remove(tokens[1]);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("People count: %d%n", peopleMap.size());

        peopleMap.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().get(0).compareTo(s1.getValue().get(0)))
                .forEach(s -> System.out.printf("%s - %d - %d%n", s.getKey(), s.getValue().get(0), s.getValue().get(1)));
    }
}
