package ListsLab;

import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<String> input = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            String value = scan.nextLine();
            input.add(value);
        }
        Collections.sort(input);

        printList(input);
    }

    private static void printList(List<String> input) {
        for (int i = 1; i < input.size(); i++) {
            System.out.println((i) + "." + input.get(i));
        }
    }


}
