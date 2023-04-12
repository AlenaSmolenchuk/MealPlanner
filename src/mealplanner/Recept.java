package mealplanner;


import java.util.Scanner;

public class Recept {
    private String category;
    private String name;
    private String[] ingredients;

    Scanner sc = new Scanner(System.in);



    protected void addRecept(){
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        category = sc.nextLine();
        System.out.println("Input the meal's name:");
        name = sc.nextLine();
        System.out.println("Input the ingredients:");
        ingredients = sc.nextLine().split(",");

        printRecept(category,name,ingredients);

    }

    protected void printRecept(String category, String name,String[] ingredients ){
        System.out.printf("Category: %s \n" +
                          "Name: %s \n" +
                          "Ingredients: ",
                          category,name);
        for (int s = 0; s < ingredients.length; s++){
            System.out.println(ingredients[s]);
        }
        System.out.println("The meal has been added!");
    }
}
