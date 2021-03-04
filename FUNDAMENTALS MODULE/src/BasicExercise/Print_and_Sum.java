package BasicExercise;

import java.util.Scanner;

public class Print_and_Sum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

int n= Integer.parseInt(scan.nextLine());
int m= Integer.parseInt(scan.nextLine());
int sum = 0;

        for (int i = n; i <= m ; i++) {
            sum+=i;
            System.out.printf("%d ",i);
        }
        System.out.printf("%nSum: %d", sum);
    }
}
