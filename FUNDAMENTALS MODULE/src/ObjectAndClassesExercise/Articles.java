package ObjectAndClassesExercise;

import java.util.Scanner;

public class Articles {
    static class NewArticle {
        String title;
        String content;
        String author;


        public NewArticle(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }


        public void renameTitle(String title) {
            this.title = title;
        }

        public void editContent(String content) {
            this.content = content;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s",
                    getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split(", ");
        String title = data[0];
        String content = data[1];
        String author = data[2];

        NewArticle newArticle = new NewArticle(title, content, author);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(": ");
            String command = input[0];

            switch (command) {
                case "Edit":
                    newArticle.editContent(input[1]);
                    break;
                case "ChangeAuthor":
                    newArticle.changeAuthor(input[1]);
                    break;
                case "Rename":
                    newArticle.renameTitle(input[1]);
                    break;
            }
        }
        System.out.println(newArticle.toString());
    }
}
