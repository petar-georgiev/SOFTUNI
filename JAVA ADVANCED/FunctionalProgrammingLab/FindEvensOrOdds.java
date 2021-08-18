package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        int lower = Integer.parseInt(tokens[0]);
        int upper = Integer.parseInt(tokens[1]);
        String option = scan.nextLine();


    }

    public static void numbers(int lower, int upper) {
        Predicate<Integer> predicate = i -> i % 2 == 0;
        for (int i = lower; i < upper; i++) {
            if(predicate.test(i)){
                System.out.println(i+" ");
            }
        }
    } public static void numbers2(int lower, int upper) {
        Predicate<Integer> predicate = i -> i % 2 != 0;
        for (int i = lower; i < upper; i++) {
            if(predicate.test(i)){
                System.out.println(i+" ");
            }
        }
    }
}
