package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] secondArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        int counter = 0;
        String output = "";
        String output2 = "";

        for (int i = 0; i < firstArr.length; i++) {
            sum += firstArr[i];
            if (firstArr[i] != secondArr[i]) {
                counter++;
                output=("Arrays are not identical. Found difference at "+ i +" index.");
                break;
            } else {
                output2=("Arrays are identical. Sum: "+sum);

            }
        }
        if(counter==0){
        System.out.println(output2);
        }else
        System.out.println(output);
    }
}

