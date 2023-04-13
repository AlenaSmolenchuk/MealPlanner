package mealplanner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Recept {
    private String category;
    private String name;
    private String[] ingredients;
    private HashMap<String,Meal> menu;

    Scanner sc = new Scanner(System.in);

    protected HashMap<String,Meal> addRecept(){
         menu = new HashMap<>();
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        category = sc.nextLine();
       if (!category.equals("breakfast")) {
           if (!category.equals( "dinner")) {
               if (!category.equals("lunch")) {
                   System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
                   addRecept();
               }
           }
       }
        System.out.println("Input the meal's name:");
        name = sc.nextLine();
        System.out.println("Input the ingredients:");
        ingredients = sc.nextLine().split(",");
        menu.put(category,new Meal(name,ingredients));

        return menu;
    }

    protected void printRecept(HashMap<String,Meal> menu) {
        if (menu.isEmpty()) {
            System.out.println("No meals saved. Add a meal first.");
            new Menu().start();
        }
       for (int i = 0; i < menu.size(); i++) {
            System.out.printf("Category: %s \n" +
                            "Name: %s \n" +
                            "Ingredients: ",
                            menu.get(i),menu.get(i).getName());
            for (int s = 0; s < menu.size(); s++) {
                System.out.println(Arrays.toString(menu.get(s).getIngredients()));
            }
            System.out.println("The meal has been added!");
        }
    }
}
