package WhileLoopLab;

import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String studentsName = scan.nextLine();
        int badGradesCounter = 0;
        double grades = 0.0;
        int clazz = 0;

        while (clazz < 12) {
            double currentGrade = Double.parseDouble(scan.nextLine());
            if (currentGrade < 4) {
                badGradesCounter++;
                if (badGradesCounter == 2) {
                    break;
                }
                continue;
            }
            clazz++;
            grades = grades + currentGrade;
        }
        if (clazz == 12) {
            System.out.printf("%s graduated. Average grade: %.2f", studentsName, grades / 12);
        }else {
            System.out.printf("%s has been excluded at %d grade", studentsName, ++clazz);
        }
    }
}
