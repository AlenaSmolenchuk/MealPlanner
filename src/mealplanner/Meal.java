package mealplanner;

public record Meal(Category category, String name, String[] ingredients) {

    @Override
    public String toString() {
        return String.format("""
                      
                        Category: %s
                        Name: %s
                        Ingredients:
                        %s""",
                category.name,
                name,
                String.join("\n", ingredients)
        );
    }
}
