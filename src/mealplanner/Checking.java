package mealplanner;

public class Checking {

    protected static boolean wrongFormat(String name){
        if(name.isBlank()) return true;
        return !name.matches("[a-zA-Z]+\\s*[a-zA-Z]*");
    }

    protected static boolean invaludIngredient(String ingredient){
        return !ingredient
                .matches("([a-zA-Z][a-zA-Z ]*,\\\\s*)*[a-zA-Z][a-zA-Z ]+");
    }
}
