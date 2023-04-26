package mealplanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tables {

    static final String DB_URL = "jdbc:postgresql://localhost:5433/meals_db";
    static final String USER = "postgres";
    static final String PASS = "1111";

    private static int mealId = 1;
    private static int ingredientId = 1;

    public static void init() {
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                connection.setAutoCommit(true);

                Statement statement = connection.createStatement();
                 statement.executeUpdate("CREATE TABLE IF NOT EXISTS meals (" +
                        "meal_id INTEGER, " +
                        "category VARCHAR, " +
                        "meal VARCHAR); ");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS ingredients (" +
                        "ingredient_id INTEGER, " +
                        "ingredient VARCHAR, " +
                        "meal_id INTEGER); ");
                
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public static void save(Meal meal){
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(true);

            PreparedStatement preparedStatementMeals = connection
                    .prepareStatement("INSERT INTO meals (meal_id, category, meal) values (?, ?, ?)");
            preparedStatementMeals.setLong(1,mealId);
            preparedStatementMeals.setString(2,meal.category().name);
            preparedStatementMeals.setString(3,meal.name());
            preparedStatementMeals.executeUpdate();

            PreparedStatement preparedStatementIngredients = connection
                    .prepareStatement("INSERT INTO ingredients (ingredient_id, ingredient, meal_id) values (?, ?, ?)");
            for (String ingredient : meal.ingredients()) {
                preparedStatementIngredients.setLong(1, ingredientId++);
                preparedStatementIngredients.setString(2, ingredient);
                preparedStatementIngredients.setLong(3, mealId);
                preparedStatementIngredients.executeUpdate();
            }

            mealId++;

            preparedStatementMeals.close();
            preparedStatementIngredients.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Meal> findAll() {
        List<Meal> meals = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(true);

            Statement statement = connection.createStatement();

            ResultSet resultMeals = statement.executeQuery("SELECT * FROM meals");

            while (resultMeals.next()) {
                long currentMealId = resultMeals.getLong("meal_id");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ingredients WHERE meal_id = ?");
                preparedStatement.setLong(1, currentMealId);
                ResultSet resultIngredients = preparedStatement.executeQuery();

                meals.add(new Meal(
                        Category.getCategory(resultMeals.getString("category")),
                        resultMeals.getString("meal"),
                        getIngredientsByMealId(resultIngredients, resultMeals.getLong("meal_id"))));
                resultIngredients.close();
                preparedStatement.close();
            }

            resultMeals.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return meals;
    }

    private static String[] getIngredientsByMealId(ResultSet resultIngredients, long mealId) {
        List<String> ingredients = new ArrayList<>();
        try {
            while (resultIngredients.next()) {
                if (resultIngredients.getLong("meal_id") == mealId)
                    ingredients.add(resultIngredients.getString("ingredient"));
            }
            return ingredients.toArray(new String[0]);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
