package ArraysMoreExercise;
import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sumVowel = 0;
        int sumConsondant = 0;
        int allSum = 0;
        int[] sortArray = new int[n];

        for (int i = 0; i < n; i++) {
            sumVowel = 0;
            sumConsondant = 0;
            String input = scan.nextLine();
            char[] inputArray = input.toCharArray();
            for (int j = 0; j < inputArray.length; j++) {

                if (inputArray[j] == 'a' || inputArray[j] == 'e' || inputArray[j] == 'i' || inputArray[j] == 'o' || inputArray[j] == 'u' || inputArray[j] == 'A' || inputArray[j] == 'E' || inputArray[j] == 'I' || inputArray[j] == 'O' || inputArray[j] == 'U') {
                    sumVowel += inputArray[j] * inputArray.length;
                } else {
                    sumConsondant += inputArray[j] / inputArray.length;
                }

                allSum = sumVowel + sumConsondant;
            }
            sortArray[i] = allSum;
        }
        Arrays.sort(sortArray);


        for (int each : sortArray) {
            System.out.println(each);
        }
    }
}
