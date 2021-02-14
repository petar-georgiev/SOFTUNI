package NestedLoopsLab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfFloor = Integer.parseInt(scan.nextLine());
        int numberOfRooms = Integer.parseInt(scan.nextLine());

        for (int i = numberOfFloor; i > 0; i--) {

            for (int j = 0; j<numberOfRooms; j++){

                if(i==numberOfFloor){
                    System.out.printf("L%d%d ",i,j );
                }
                else if (i%2==0){
                    System.out.printf("O%d%d ",i,j );
                }
                else
                {
                    System.out.printf("A%d%d ",i,j );
                }

            }
            System.out.println();
        }
    }
}
