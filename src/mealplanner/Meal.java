package mealplanner;

public final class Meal {
    private final String category;
    private final String name;
    private final String[] ingredients;

    public Meal(String category, String name, String[] ingredients) {
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
                             category,
                             name,
                             String.join("\n", ingredients));
    }

    public String category() {
        return category;
    }

    public String name() {
        return name;
    }

    public String[] ingredients() {
        return ingredients;
    }
}
