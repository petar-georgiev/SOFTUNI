package ObjectAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {

    static class Catalogue {
        String typeOfVehicle;
        String model;
        String color;
        int horsepower;

        public Catalogue(String typeOfVehicle, String model, String color, int horsepower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getTypeOfVehicle() {
            return typeOfVehicle;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %s", firstLetterUpStr(typeOfVehicle), model, color, horsepower);
        }

        public String firstLetterUpStr(String string) {
            String firstLetter = typeOfVehicle.substring(0, 1).toUpperCase();
            String remainingLetters = typeOfVehicle.substring(1, typeOfVehicle.length());

            return firstLetter + remainingLetters;
        }
    }

    public static double avrHorsepower(List<Catalogue> catalogues) {
        if(catalogues.size()==0){
            return 0.0;
        }
        return catalogues.stream().mapToDouble(Catalogue::getHorsepower).sum() / catalogues.size();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Catalogue> catalogueList = new ArrayList<>();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String type = data[0];
            String model = data[1];
            String color = data[2];
            int horsepower = Integer.parseInt(data[3]);

            Catalogue catalogue = new Catalogue(type, model, color, horsepower);

            catalogueList.add(catalogue);

            input = scan.nextLine();
        }
        input = scan.nextLine();

        List<Catalogue> catalogueHPList = new ArrayList<>();
        int counter = 0;
        while (!input.equals("Close the Catalogue")) {
            counter++;
            String model = input;

            catalogueList.stream()
                    .filter(catalogue -> catalogue.getModel().equals(model))
                    .forEach(System.out::println);


            input = scan.nextLine();
        }

        List<Catalogue> cars = catalogueList.stream()
                .filter(catalogue -> catalogue.typeOfVehicle.equals("car"))
                .collect(Collectors.toList());

        List<Catalogue> trucks = catalogueList.stream()
                .filter(catalogue -> catalogue.typeOfVehicle.equals("truck"))
                .collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n", avrHorsepower(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.", avrHorsepower(trucks));
    }
}
