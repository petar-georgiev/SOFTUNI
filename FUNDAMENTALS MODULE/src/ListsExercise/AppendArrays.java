package ListsExercise;

import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arrays = scan.nextLine().split("\\|");

        String result = "";

        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] currentArr = arrays[i].split("\\s+");
            for (int j = 0; j < currentArr.length; j++) {
                if (!currentArr[j].equals("")) {
                    result += currentArr[j] + " ";
                }
            }
        }
        System.out.println(result.trim());
    }
}
