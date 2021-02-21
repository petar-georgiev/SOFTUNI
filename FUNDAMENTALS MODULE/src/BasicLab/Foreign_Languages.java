package BasicLab;

import java.util.Scanner;

public class Foreign_Languages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String country = scan.nextLine();
        switch (country) {
            case "England":
            case "USA":
                System.out.println("English");
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
