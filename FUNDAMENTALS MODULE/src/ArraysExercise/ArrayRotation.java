package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int rotationInput = Integer.parseInt(scan.nextLine());

        if(rotationInput>arr.length){
            rotationInput-=arr.length;

        }
        int[] newArr = new int[arr.length];
        int numbersCount = 0;

        for (int i = 0; i < arr.length-rotationInput; i++) {
            newArr[i]=arr[i+rotationInput];
            numbersCount++;
        }
        int arrIt=0;
        for (int j = numbersCount; j < newArr.length; j++) {
            newArr[j]=arr[arrIt];
            arrIt++;
        }
        for (int each: newArr  ) {
            System.out.print(each+ " ");
        }
   }
}
