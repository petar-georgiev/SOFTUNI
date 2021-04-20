package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> firstCar = new ArrayList<>();
        List<Integer> secondCar = new ArrayList<>();
        double totalTimeFirst = 0.0;
        double totalTimeSecond = 0.0;

        for (int i = 0; i < input.size() / 2; i++) {
            firstCar.add(input.get(i));
        }
        for (int j = input.size() - 1; j > input.size() / 2; j--) {
            secondCar.add(input.get(j));
        }
        for (int i = 0; i < firstCar.size(); i++) {
            if (firstCar.get(i) == 0) {
                totalTimeFirst*=0.8;
            } else {
                totalTimeFirst += firstCar.get(i);
            }
        }
        for (int j = 0; j < secondCar.size(); j++) {
            if (secondCar.get(j) == 0) {
                totalTimeSecond*=0.8;
            } else {
                totalTimeSecond += secondCar.get(j);
            }
        }
        if(totalTimeFirst<totalTimeSecond)
        System.out.printf("The winner is left with total time: %.1f",totalTimeFirst);
       else
            System.out.printf("The winner is right with total time: %.1f",totalTimeFirst);

        }
    }

