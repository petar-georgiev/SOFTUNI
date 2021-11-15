package E04TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] colors = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        List<Light> lightsList = new ArrayList<>();

        while (n-- > 0) {
            for (int i = 0; i < colors.length; i++) {
                Light light = new Light(Color.valueOf(colors[i]));
                lightsList.add(light);
                light.changeColor();
                colors[i] = light.getColor().name();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
