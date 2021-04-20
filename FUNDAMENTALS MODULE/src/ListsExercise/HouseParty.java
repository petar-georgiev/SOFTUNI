package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> partyGuestsList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split(" ");
            String names = tokens[0];
            if (tokens[1].equals("is") && tokens[2].equals("going!")) {
                if (partyGuestsList.contains(names)) {
                    System.out.printf("%s is already in the list! %n", names);
                }else
                partyGuestsList.add(names);
            }
            else {
                if(!partyGuestsList.contains(names)){
                    System.out.printf("%s is not in the list! %n", names);

                }else
                partyGuestsList.remove(new String(names));
            }
        }
        printList(partyGuestsList);
    }

    private static void printList(List<String> inputs) {
        for (String each : inputs) {
            System.out.println(each);
        }
    }
}
