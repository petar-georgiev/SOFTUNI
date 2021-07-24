package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int degrees = Integer.parseInt(scan.nextLine().split("[()]+")[1])%360;

        String input = scan.nextLine();

        List<String> stringList = new ArrayList<>();

        while (!input.equals("END")) {
            stringList.add(input);
            input = scan.nextLine();
        }

        String biggestLength = stringList.stream()
                .max(Comparator.comparingInt(String::length))
                .get();

        switch (degrees) {
            case 0:
                for (String s : stringList) {
                    System.out.println(s);
                }
                break;

            case 180:
                int rows = stringList.size() - 1;
                int cols = biggestLength.length() - 1;
                StringBuilder sb = new StringBuilder();


                while (rows >= 0) {
                    try {
                        sb.append(stringList.get(rows).charAt(cols));

                        if (cols == 0) {
                            System.out.println(sb);
                            sb = new StringBuilder();
                            rows--;
                            cols = biggestLength.length();
                        }
                        cols--;
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.print(" ");
                        cols--;
                    }
                }
                break;
            case 90:
                rows = stringList.size() - 1;
                cols = 0;
                sb = new StringBuilder();

                while (cols < biggestLength.length()) {
                    try {
                        sb.append(stringList.get(rows).charAt(cols));
                        rows--;

                        if (rows < 0) {
                            System.out.println(sb);
                            sb = new StringBuilder();
                            cols++;
                            rows = stringList.size() - 1;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        if (rows <= 0) {
                            System.out.println(sb);
                            sb = new StringBuilder();
                            rows = stringList.size() - 1;
                            cols++;
                        } else {
                            System.out.print(" ");
                            rows--;
                        }
                    }
                }
                break;
            case 270:
                rows = 0;
                cols = biggestLength.length() - 1;
                sb = new StringBuilder();

                while (cols >= 0) {
                    try {
                        sb.append(stringList.get(rows).charAt(cols));
                        rows++;

                        if (rows > stringList.size() - 1) {
                            System.out.println(sb);
                            sb = new StringBuilder();
                            cols--;
                            rows = 0;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        if (rows >= stringList.size() - 1) {
                            System.out.println(sb);
                            sb = new StringBuilder();
                            rows = 0;
                            cols--;
                        } else {
                            System.out.print(" ");
                            rows++;
                        }
                    }
                }
                break;
        }
    }
}
