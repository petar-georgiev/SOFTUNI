package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int examHour = Integer.parseInt(scan.nextLine());
        int examMinutes = Integer.parseInt(scan.nextLine());
        int arriveHour = Integer.parseInt(scan.nextLine());
        int arriveMinutes = Integer.parseInt(scan.nextLine());
        int examTime = examHour * 60 + examMinutes;
        int arriveTime = arriveHour * 60 + arriveMinutes;
        String output1 = "";
        String output2 = "";

//On time
        if (arriveTime <= examTime && arriveTime >= examTime - 30) {
            output1 = "On time";
            int difference = examTime - arriveTime;
            if (difference < 60) {
                output2 = String.format("%d minutes before the start", difference);
            }
        }

        //Early
        else if (arriveTime < (examTime - 30)) {
            output1 = "Early";
            int difference = examTime - arriveTime;
            if (difference < 60) {
                output2 = String.format("%d minutes before the start", difference);

            } else {
                int hours = difference / 60;
                int minutes = difference % 60;
                output2 = String.format("%d:%02d hours before the start", hours, minutes);
            }

            //Late
        } else if (arriveTime > examTime) {
            output1 = "Late";
            int difference = arriveTime - examTime;

            if (difference < 60) {
                output2 = String.format("%d minutes after the start", difference);
            } else {
                int hours = difference / 60;
                int minutes = difference % 60;
                output2 = String.format("%d:%02d hours after the start", hours, minutes);
            }
        }
        System.out.println(output1);
        System.out.println(output2);
    }
}
