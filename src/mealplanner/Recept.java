package mealplanner;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Recept {
    private String category;
    private String name;
    private String[] ingredients;
    Scanner sc = new Scanner(System.in);

    protected HashMap<String,Meal> addRecept() {
        HashMap<String, Meal> menu = new HashMap<>();
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        category = sc.nextLine();
        if (!category.equals("breakfast") && !category.equals("dinner") && !category.equals("lunch")) {
            System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            return addRecept();
        }
        System.out.println("Input the meal's name:");
        name = sc.nextLine();
        while (!Pattern.matches("[a-zA-Z]+", name)) {
            System.out.println("Wrong format. Use letters only!");
            name = sc.nextLine();
        }
            System.out.println("Input the ingredients:");
            ingredients = sc.nextLine().split(",");
            for (int i = 0; i < ingredients.length; i++) {
                while (!Pattern.matches("[a-zA-Z]+", ingredients[i])) {
                    System.out.println("Wrong format. Use letters only!");
                    ingredients = sc.nextLine().split(",");
                }
            }
        menu.put(category, new Meal(name, ingredients));
        System.out.println("The meal has been added!");
        return menu;
    }


    protected void printRecept(HashMap<String,Meal> menu) {
        if (menu.isEmpty()) {
            System.out.println("No meals saved. Add a meal first.");
            new Menu().start();
        }
       for (int i = 1; i < menu.size(); i++) {
            System.out.printf("Category: %s \n" +
                            "Name: %s \n" +
                            "Ingredients: %s ",
                            menu.get(i),menu.get(i).getName(),menu.get(i).getIngredients());
       }
    }
}
