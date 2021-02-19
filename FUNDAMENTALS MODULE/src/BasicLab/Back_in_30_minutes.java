package BasicLab;

import java.util.Scanner;

public class Back_in_30_minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        if (hours==23&&minutes>20){
            hours=-1;
        }

        int hoursToMinutes = hours*60;
        int allInMinutes = hoursToMinutes+minutes+30;
        int minutesToHours =allInMinutes/60;
        int minutesToHoursRemain = allInMinutes%60;



        System.out.printf("%d:%02d",minutesToHours,minutesToHoursRemain);



    }
}
