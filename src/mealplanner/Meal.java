package mealplanner;

public class Meal {

    private String name;
    private String[] ingredients;

    public Meal(String name, String[] ingredients) {

        this.name = name;
        this.ingredients = ingredients;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        String output = null;
        for (int i = 0; i < ingredients.length; i++) {
            output = ingredients[i] + "\n";
        }
        return output;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    
}
