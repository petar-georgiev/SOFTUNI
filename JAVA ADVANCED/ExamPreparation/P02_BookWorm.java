package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_BookWorm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scan.nextLine());
        List<String> matrix = new ArrayList<>();


        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            matrix.add(scan.nextLine());
        }
        List<Integer> positionP = initialPositionOfPlayer(matrix);

        String regex = "\\w";
        Pattern pattern = Pattern.compile(regex);
        String move = scan.nextLine();

        while (!move.equals("end")) {
            List<Integer> oldPositionP = new ArrayList<>(positionP);


            switch (move) {
                case "up":
                    positionP.add(0, positionP.get(0) - 1);
                    positionP.remove(1);
                    actions(sb, matrix, positionP, pattern, oldPositionP);
                    break;

                case "down":
                    positionP.add(0, positionP.get(0) + 1);
                    positionP.remove(1);
                    actions(sb, matrix, positionP, pattern, oldPositionP);
                    break;

                case "left":
                    positionP.add(1, positionP.get(1) - 1);
                    positionP.remove(positionP.size() - 1);
                    actions(sb, matrix, positionP, pattern, oldPositionP);
                    break;
                case "right":
                    positionP.add(1, positionP.get(1) + 1);
                    positionP.remove(positionP.size() - 1);
                    actions(sb, matrix, positionP, pattern, oldPositionP);
                    break;
            }
            move = scan.nextLine();
        }

        System.out.println(sb);
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).length(); col++) {
                System.out.print(matrix.get(row).charAt(col));
            }
            System.out.println();
        }
    }

    private static void changeWrongPosition(List<Integer> oldPositionP, List<String> matrix) {
        String line = matrix.get(oldPositionP.get(0));
        for (int col = 0; col < line.length(); col++) {
            if (col == oldPositionP.get(1)) {
                matrix.set(oldPositionP.get(0), changeChar(matrix.get(oldPositionP.get(0)), col));
            }
        }
    }

    private static String changeChar(String s, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == col) {
                sb.append('P');
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    private static void actions(StringBuilder sb, List<String> matrix, List<Integer> positionP, Pattern pattern, List<Integer> oldPositionP) {
        if (positionP.get(0) < 0 || positionP.get(0) > matrix.size()
                || positionP.get(1) < 0 || positionP.get(1) > matrix.get(0).length()) {
            sb.deleteCharAt(sb.length() - 1);
            changeWrongPosition(oldPositionP, matrix);
            return;
        }
        Matcher matcher = pattern.matcher(charCheck(positionP, matrix));
        if (matcher.find()) {
            changePosition(positionP, matrix, matcher.group());
            changeOldPosition(oldPositionP, matrix);
            sb.append(matcher.group());
        }
    }

    private static void changeOldPosition(List<Integer> oldPositionP, List<String> matrix) {
        String line = matrix.get(oldPositionP.get(0));
        for (int col = 0; col < line.length(); col++) {
            if (col == oldPositionP.get(1)) {
                matrix.set(oldPositionP.get(0), line.replaceFirst("P", "-"));
            }
        }
    }

    private static void changePosition(List<Integer> positionP, List<String> matrix, String group) {
        String line = matrix.get(positionP.get(0));
        for (int col = 0; col < line.length(); col++) {
            if (col == positionP.get(1)) {
                matrix.set(positionP.get(0), line.replace(group.charAt(0), 'P'));
            }
        }
    }

    private static CharSequence charCheck(List<Integer> positionP, List<String> matrix) {
        String line = matrix.get(positionP.get(0));
        for (int col = 0; col < line.length(); col++) {
            if (col == positionP.get(1)) {
                return line.charAt(col) + "";
            }
        }
        return "";
    }

    private static List<Integer> initialPositionOfPlayer(List<String> matrix) {
        List<Integer> positionP = new ArrayList<>();
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).length(); col++) {
                if (matrix.get(row).charAt(col) == 'P') {
                    positionP.add(row);
                    positionP.add(col);
                }
            }
        }
        return positionP;
    }
}
