package mealplanner;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
 
    private HashMap<String,Meal> menu = new HashMap<>(10000000);
    Scanner sc = new Scanner(System.in);
    Recept recept = new Recept();

    public void start(){
        boolean check = true;
        while(check) {
            System.out.println("What would you like to do (add, show, exit)?");
            String output = sc.nextLine();
            switch (output) {
                case "add":
                    menu = recept.addRecept();
                    break;
                case "show":
                    recept.printRecept(menu);
                    break;
                case "exit":
                    System.out.println("Bye!");
                    check = false;
                    break;
                default:
                    break;
            }
            if(!check){
                break;
            }
        }
    }
}
