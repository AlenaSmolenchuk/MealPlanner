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

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "\n Ingredients: " + ingredients;
    }
}
