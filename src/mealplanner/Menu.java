package mealplanner;


import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    Recept recept = new Recept();

    public void start(){
        Tables.init();
        boolean exit = true;

        while(exit) {
            System.out.println("What would you like to do (add, show, exit)?");
            String output = sc.nextLine();
            switch (output) {
                case "add" :
                    recept.addRecept();
                    break;
                case "show" :
                    recept.showRecept();
                    break;
                case "exit" :
                    System.out.println("Bye!");
                    exit = false;
                    break;
                default:
                    break;
            }
        if (!exit){
            break;
        }
        }
    }
}


