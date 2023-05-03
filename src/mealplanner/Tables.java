package mealplanner;

import java.sql.*;
import java.util.List;

public class Database {

    Connection connection;
    Statement statement;

    ResultSet rs;
    ResultSet is;

    int mealId = 1;

    public void databaseInit() throws SQLException {
        String DB_URL = "jdbc:postgresql://localhost:5433/meals_db";
        String USER = "postgres";
        String PASS = "1111";

        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        connection.setAutoCommit(true);
        statement = connection.createStatement();
        createTables();

    }

    public void createTables() throws SQLException {
        statement.executeUpdate("create table IF NOT EXISTS meals (" +
                "category varchar(20)," +
                "meal varchar(20)," +
                "meal_id integer" +
                " )");
        statement.executeUpdate("create table IF NOT EXISTS ingredients (" +
                "ingredient varchar(20)," +
                "meal_id integer," +
                "ingredient_id integer" +
                " )");
    }

    public void insertMeal(String category, String name, List<String> ingredients) throws SQLException {

        statement.executeUpdate(String.format("insert into meals (category, meal, meal_id) values ('%s','%s',%d)", category, name, mealId));
        ingredients.forEach(item ->
        {
            try {
                statement.executeUpdate(String.format("insert into ingredients (ingredient,meal_id) values ('%s', %d)", item, mealId));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        mealId++;
        System.out.println("The meal has been added!");
    }

    public void showTables() throws SQLException {
        int rowNum = 0;
        is = statement.executeQuery("select * from meals");
        while (is.next()) {
            rowNum = is.getRow();
        }
        rs = statement.executeQuery("select meals.meal, meals.category, ingredients.ingredient from meals JOIN ingredients ON meals.meal_id = ingredients.meal_id");
        if (rowNum == 0) {
            System.out.println("No meals saved. Add a meal first.");
        } else {
            String currentMeal = "";
            while (rs.next()) {
                String mealName = rs.getString("meal");
                String category = rs.getString("category");
                String ingredient = rs.getString("ingredient");

                if (!currentMeal.equals(mealName)) {
                    System.out.println();
                    System.out.println("Category: " + category);
                    System.out.println("Name: " + mealName);
                    System.out.println("Ingredients:");
                    currentMeal = mealName;
                }
                System.out.println(ingredient);

            }
            System.out.println();
        }
    }
}
