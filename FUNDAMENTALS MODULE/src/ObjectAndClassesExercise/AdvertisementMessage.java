package ObjectAndClassesExercise;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

    static class Message {
        String[] phrases = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};
        String[] events = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public void setPhrases(String[] phrases) {
            this.phrases = phrases;
        }

        public String[] getPhrases() {
            return phrases;
        }

        public String[] getEvents() {
            return events;
        }

        public void setEvents(String[] events) {
            this.events = events;
        }

        public String[] getAuthors() {
            return authors;
        }

        public void setAuthors(String[] authors) {
            this.authors = authors;
        }

        public String[] getCities() {
            return cities;
        }

        public void setCities(String[] cities) {
            this.cities = cities;
        }

        Random rnd = new Random();

        public String randomMessage() {
            return String.format("%s %s %s – %s", phrases[rnd.nextInt(phrases.length)],
                    events[rnd.nextInt(events.length)],
                    authors[rnd.nextInt(authors.length)],
                    cities[rnd.nextInt(cities.length)]);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            Message msg = new Message();
            System.out.println(msg.randomMessage());


        }
    }
}
