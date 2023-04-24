package mealplanner;

import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    Recept recept = new Recept();

    public void start(){
        boolean exit = false;

        while(!exit) {
            System.out.println("What would you like to do (add, show, exit)?");
            switch (Command.getCommand(sc.nextLine())) {
                case ADD -> recept.addRecept();
                case SHOW -> recept.showRecept();
                case EXIT -> exit = true;
                case UNKNOWN -> {
                }
            }
        }
        System.out.println("Bye!");
    }
}
