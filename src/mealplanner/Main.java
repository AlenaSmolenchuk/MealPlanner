package mealplanner;


import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    Menu menu = new Menu();
    Database database = new Database();
    database.databaseInit();


    while(!menu.isOver) {
      menu.run(database);
    }
    System.out.println("Bye!");
  }
}
