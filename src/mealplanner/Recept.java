package mealplanner;

import java.util.*;

public class Recept {
    private Category category;
    private String name;
    private String[] ingredients;


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
        name = sc.nextLine();
        while (Checking.wrongFormat(name)) {
            System.out.println("Wrong format. Use letters only!");
            name = sc.nextLine();
        }

        System.out.println("Input the ingredients:");
        ingredients = sc.nextLine().split(",");
        for (int i = 0; i < ingredients.length; i++){
            if(Checking.invaludIngredient(ingredients[i])) {
                System.out.println("Wrong format. Use letters only!");
                i = 0;
                ingredients = sc.nextLine().split(",");
            }
        }

          FromTables.save(new Meal(category,name,ingredients));
          System.out.println("The meal has been added!");
    }

    protected void showRecept() {
        List<Meal> meals = FromTables.findAll();
        if (meals.isEmpty()) {
            System.out.println("No meals saved. Add a meal first.");
            return;
        }
        meals.forEach(System.out::println);
        }
    }

