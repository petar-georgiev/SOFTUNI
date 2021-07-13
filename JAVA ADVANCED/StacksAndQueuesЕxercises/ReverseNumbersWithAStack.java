package StacksAndQueues≈xercises;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String print = "";
        ArrayDeque<Integer> numbersReversed = new ArrayDeque<>();
        int [] Numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int num: Numbers) {
            numbersReversed.push(num);
        }
        while (numbersReversed.size()>0){
            System.out.print(numbersReversed.pop()+ " ");
        }
    }
}
