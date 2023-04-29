package mealplanner;


public final class Meal {
    private final Category category;
    private final String name;
    private final String[] ingredients;
 
    public Meal(Category category, String name, String[] ingredients) {
        this.category = category;
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return String.format("Category: %s \n" +
                             "Name: %s \n" +
                             "Ingredients: \n" +
                             "%s",
                             category.name,
                             name,
                             String.join("\n", ingredients));
    }

    public Category category() {
        return category;
    }

    public String name() {
        return name;
    }

    public String[] ingredients() {
        return ingredients;
    }
}
