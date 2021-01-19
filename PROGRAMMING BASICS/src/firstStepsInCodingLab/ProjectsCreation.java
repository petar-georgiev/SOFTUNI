package firstStepsInCodingLab;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        String nameArchitect = scan.nextLine();
        int projects = scan.nextInt();
        int neededHours = projects * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", nameArchitect, neededHours, projects);
    }
}
