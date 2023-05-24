package mealplanner;

import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    boolean isOver = false;

    public void run(Database database) throws SQLException {
        switch (makeChoice()) {
            case "show":
                database.showTables();
            case "add":
                System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
                database.insertMeal(getCategoryInput(),getNameInput(),getIngredients());
            case "exit":
            isOver = true;
        }
    }

    public String makeChoice() {
        System.out.println("What would you like to do (add, show, exit)?");
        return new Scanner(System.in).nextLine().toLowerCase();
    }

    private String getCategoryInput() {
        List<String> meals = List.of("breakfast", "lunch", "dinner");
        String input = new Scanner(System.in).nextLine().toLowerCase();
        if (!meals.contains(input)) {
            System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            return getCategoryInput();
        }
        return input;
    }

    public String getNameInput() {
        System.out.println("Input the meal's name:");
        String input = new Scanner(System.in).nextLine().toLowerCase();
        if (Checking.wrongFormat(input) || input.isBlank() || input.isEmpty()) {
            System.out.println("Wrong format. Use letters only!");
            return getNameInput();
        }
        return input;
    }

    public List<String> getIngredients() {
        System.out.println("Input the ingredients:");
        List<String> input = List.of(new Scanner(System.in).nextLine().split(", "));
        for (String ingredients : input) {
            if (Checking.invalidIngredient(ingredients) || ingredients.isBlank()) {
                System.out.println("Wrong format. Use letters only!");
                return getIngredients();
            }
        }
        return input;
    }
}
