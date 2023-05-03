package mealplanner;

import java.util.Objects;

public class Checking {

    protected static boolean wrongFormat(String name){
        if(name.isBlank()) return true;
        return !name.matches("[a-zA-Z ]+");
    }

    protected static boolean invalidIngredient(String ingredient){
        return !ingredient
                .matches("[a-zA-Z ]+");
    }
}
