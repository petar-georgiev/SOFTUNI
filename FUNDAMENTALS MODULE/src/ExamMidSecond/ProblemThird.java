package ExamMidSecond;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemThird {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> bookList = Arrays.stream(scan.nextLine().split("&"))
                .collect(Collectors.toList());


        String input = scan.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split(" \\| ");

            switch (tokens[0]) {
                case "Add Book":
                    if (!bookList.contains(tokens[1]))
                        bookList.add(0, tokens[1]);
                    break;

                case "Take Book":
                    bookList.remove(tokens[1]);
                    break;

                case "Swap Books":
                    int getIndexFirst = bookList.indexOf(tokens[1]);
                    int getIndexSecond = bookList.indexOf(tokens[2]);

                    if ((getIndexFirst >= 0 && getIndexFirst <= bookList.size() - 1) &&
                            (getIndexSecond >= 0 && getIndexSecond <= bookList.size() - 1)) {
                        bookList.set(getIndexFirst, tokens[2]);
                        bookList.set(getIndexSecond, tokens[1]);
                    }
                    break;

                case "Insert Book":
                    bookList.add(tokens[1]);
                    break;

                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index <= bookList.size() - 1) {
                        System.out.println(bookList.get(index));
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ", bookList));
    }
}
