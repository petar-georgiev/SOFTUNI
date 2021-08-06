package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> usernamesSet = new LinkedHashSet<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            usernamesSet.add(scan.nextLine());
        }
        for (String s : usernamesSet) {
            System.out.println(s);
        }
    }
}
