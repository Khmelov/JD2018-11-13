package by.it.seroglazov.jd03_03.beans;

public class Amount {
    private long recipe_id;
    private long ingredient_id;
    private String text;
    private long unit_id;

    public Amount(long recipe_id, long ingredient_id, String text, long unit_id) {
        this.recipe_id = recipe_id;
        this.ingredient_id = ingredient_id;
        this.text = text;
        this.unit_id = unit_id;
    }

    public Amount() {
    }

    public long getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(long recipe_id) {
        this.recipe_id = recipe_id;
    }

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(long unit_id) {
        this.unit_id = unit_id;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "recipe_id=" + recipe_id +
                ", ingredient_id=" + ingredient_id +
                ", text='" + text + '\'' +
                ", unit_id=" + unit_id +
                '}';
    }
}
