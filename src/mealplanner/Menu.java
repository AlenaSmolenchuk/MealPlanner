package mealplanner;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {  
    private HashMap<String,Meal> menu = new HashMap<>(1000000);
    Scanner sc = new Scanner(System.in);
    Recept recept = new Recept();

    public void start(){
        System.out.println("What would you like to do (add, show, exit)?");
        String output = sc.nextLine();
        switch (output){
            case "add":
                menu = recept.addRecept();
                start();
            case "show":
                recept.printRecept(menu);
                start();
            case "exit":
                System.out.println("Bye!");
                return;
            default:
                System.out.println("What would you like to do (add, show, exit)?");
                start();
        }
    }
}
