package conditionalStatementAdvancedLab;

import java.util.Scanner;

public class FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stock = scan.nextLine();
        if (stock.equals("banana")||stock.equals("apple")|| stock.equals("kiwi")||
                stock.equals("cherry") || stock.equals("lemon") || stock.equals("grapes")) {
            System.out.println("fruit");
        } else if (stock.equals("tomato") || stock.equals("cucumber") || stock.equals("pepper")
                || stock.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}
