package DatabaseAccessWithJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class JavaDbEx {

    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    //"jdbc:mysql://localhost:3306/minions_db"
    // username: root
    // password: toor


    public static void main(String[] args) throws SQLException, IOException {

        connection = getConnection();

        System.out.println("Input exercise number:");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 2 -> exTwo();
            case 3 -> exThree();
            case 4 -> exFour();
            case 5 -> exFive();
            case 7 -> exSeven();
            case 8 -> exEight();
            case 9 -> exNine();
        }
    }

    private static void exTwo() throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("select v.name, count(distinct mv.minion_id) as cnt from villains v" +
                        "join minions_villains mv on v.id = mv.villain_id" +
                        "group by v.name" +
                        "having cnt > 15" +
                        "order by cnt desc;");


        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n",
                    resultSet.getString("name"),
                    resultSet.getInt("cnt"));
        }
    }

    private static void exThree() throws SQLException, IOException {
        System.out.println("Input villain id:");
        int vId = Integer.parseInt(reader.readLine());


        getNameById(vId, "villains");


        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "select m.name, age from villains as v\n" +
                "join minions_villains mv on v.id = mv.villain_id\n" +
                "join minions m on m.id = mv.minion_id\n" +
                "where villain_id = ?;");

        preparedStatement.setInt(1, vId);

        ResultSet resultSet = preparedStatement.executeQuery();

        int n = 1;

        while (resultSet.next()) {
            System.out.printf("%d. %s %d %n", n++, resultSet.getString("m.name"),
                    resultSet.getInt("age"));
        }
    }

    private static void exFour() throws IOException, SQLException {
        System.out.println("Input info: ");
        String[] tokens = reader.readLine().split(" ");
        String nameOfMinion = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String town = tokens[3];
        String nameOfVillain = reader.readLine().split(" ")[1];

        int idOfTown = getOrInsertId(town, "towns");
        int idOfVillain = getOrInsertId(nameOfVillain, "villains");

        PreparedStatement preparedStatementInsMinions = connection.prepareStatement(
                "insert into minions(name, age, town_id)\n" +
                        "values (?,?,?);");

        preparedStatementInsMinions.setString(1, nameOfMinion);
        preparedStatementInsMinions.setInt(2, age);
        preparedStatementInsMinions.setInt(3, idOfTown);

        preparedStatementInsMinions.executeUpdate();

        PreparedStatement preparedStatementSelMinnions = connection.prepareStatement(
                "select id from minions where name = ?;");

        preparedStatementSelMinnions.setString(1, nameOfMinion);

        ResultSet resultSet = preparedStatementSelMinnions.executeQuery();
        resultSet.next();
        int idOfMinnion = resultSet.getInt("id");

        PreparedStatement preparedStatementInsMinVil = connection.prepareStatement(
                "insert into minions_villains values (?,?)");

        preparedStatementInsMinVil.setInt(1, idOfMinnion);
        preparedStatementInsMinVil.setInt(2, idOfVillain);
        preparedStatementInsMinVil.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n",
                nameOfMinion, nameOfVillain);

    }

    private static void exFive() throws SQLException, IOException {
        System.out.println("Input country name: ");
        String countryName = reader.readLine();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "update towns\n" +
                        "    set name = upper(name)\n" +
                        "where country = ?;"
        );

        preparedStatement.setString(1, countryName);
        int affectedRows = preparedStatement.executeUpdate();

        PreparedStatement preparedStatementSel = connection.prepareStatement(
                "select * from towns where country = ?;");
        preparedStatementSel.setString(1, countryName);

        ResultSet resultSet = preparedStatementSel.executeQuery();


        List<String> results = new LinkedList<>();

        while (resultSet.next()) {
            results.add(resultSet.getString("name"));
        }
        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.printf("%d town names were affected.%n%s", affectedRows, results);
        }
    }

    private static void exSeven() throws SQLException {
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> reversedStack = new ArrayDeque<>();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "select name from minions");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            stack.offer(resultSet.getString("name"));
            reversedStack.push(resultSet.getString("name"));
        }

        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.poll());
            System.out.println(reversedStack.poll());
        }
    }

    private static void exEight() throws IOException, SQLException {
        System.out.println("Input ID's of minions: ");

        String[] input = reader.readLine().split("\s+");

        System.out.println();

        PreparedStatement preparedStatementUpd = connection.prepareStatement(
                "update minions set name = lower(name), age = age + 1 where id in (" + String.join(", ", input) + ")");

        preparedStatementUpd.executeUpdate();

        PreparedStatement preparedStatementSel = connection.prepareStatement(
                "select name, age from minions"
        );

        ResultSet resultSet = preparedStatementSel.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %d%n",
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        }
    }

    private static void exNine() throws IOException, SQLException {
        System.out.printf("Enter minion id: ");
        int minionId = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection
                .prepareCall("call usp_get_older(?)");
        callableStatement.setInt(1, minionId);

        callableStatement.executeUpdate();
    }

    private static int getOrInsertId(String name, String table_name) throws SQLException {

        PreparedStatement preparedStatementSelect = connection.prepareStatement(
                "select id from " + table_name + "  as t\n" +
                        "where t.name = ?;");

        preparedStatementSelect.setString(1, name);

        ResultSet resultSet = preparedStatementSelect.executeQuery();

        if (!resultSet.next()) {
            PreparedStatement preparedStatementInsert;

            if (table_name.equals("villains")) {
                preparedStatementInsert = connection.prepareStatement(
                        "insert into villains(name, evilness_factor)\n" +
                                "values (?, ?);");
                preparedStatementInsert.setString(1, name);
                preparedStatementInsert.setString(2, "evil");
                System.out.printf("Villain %s was added to the database.%n", name);

            } else {
                preparedStatementInsert = connection.prepareStatement(
                        "insert into " + table_name + "(name)\n" +
                                "values (?);");
                preparedStatementInsert.setString(1, name);
                System.out.printf("Town %s was added to the database.%n", name);
            }
            preparedStatementInsert.executeUpdate();
            ResultSet newResultSet = preparedStatementSelect.executeQuery();
            newResultSet.next();
            return newResultSet.getInt("id");
        }
        return resultSet.getInt("id");
    }

    private static void getNameById(int id, String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select name from " + tableName + "\n" +
                "where id = ?;");

        preparedStatement.setInt(1, id);


        ResultSet resultSet = preparedStatement.executeQuery();
        String tableNameType = tableName.substring(0, 1)
                .toUpperCase() + tableName.substring(1, tableName.length() - 1);

        if (!resultSet.next()) {
            System.out.println("No " + tableName.substring(0, tableName.length() - 1) + " with ID 10 exists in the database");
            return;
        } else {
            System.out.println(tableNameType + ": " + resultSet.getString("name"));
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "toor");
    }
}
