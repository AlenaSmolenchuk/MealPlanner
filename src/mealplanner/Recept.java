package mealplanner;

import java.util.*;

public class Recept {
    private Category category;
    private String name;
    private String[] ingredients;
    private String ingredient;

    Scanner sc = new Scanner(System.in);

    protected void addRecept() {
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
         category = null;
        while (category == null){
            category = Category.getCategory(sc.nextLine());
            if (category == null){
                System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            }
        }

        System.out.println("Input the meal's name:");
        name = "";
        while (Checking.wrongFormat(name)) {
            System.out.println("Wrong format. Use letters only!");
            name = sc.nextLine();
        }

        System.out.println("Input the ingredients:");
        ingredient = "";
        while (Checking.invaludIngredient(ingredient)){
            ingredient = sc.nextLine();
            System.out.println("Wrong format. Use letters only!");
        }

          ingredients = ingredient.split("\\s*,\\s*");
          Tables.save(new Meal(category,name,ingredients));
          System.out.println("The meal has been added!");
    }


    protected void showRecept() {
        List<Meal> meals = Tables.findAll();
        if (meals.isEmpty()) {
            System.out.println("No meals saved. Add a meal first.");
            return;
        }
        meals.forEach(System.out::println);
        }
    }
