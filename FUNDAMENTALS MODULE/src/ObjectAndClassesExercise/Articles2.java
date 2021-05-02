package ObjectAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    static class Article {
        String title;
        String content;
        String author;


        public Article(String title, String content, String author) {
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
        List<Article> articleList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];

            Article article = new Article(title, content, author);

            articleList.add(article);
        }

        String option = scan.nextLine();

        switch (option) {
            case "title":
                articleList.stream()
                        .sorted((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "content":
                articleList.stream()
                        .sorted((p1, p2) -> p1.getContent().compareTo(p2.getContent()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "author":
                articleList.stream()
                        .sorted((p1, p2) -> p1.getAuthor().compareTo(p2.getAuthor()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
        }
    }
}
