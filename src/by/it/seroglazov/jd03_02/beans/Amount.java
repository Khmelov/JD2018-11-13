package by.it.seroglazov.jd03_02.beans;

public class Amount {
    private Ingredient ingredient;
    private String text;
    private Unit unit;

    public Amount(Ingredient ingredient, String text, Unit unit) {
        this.ingredient = ingredient;
        this.text = text;
        this.unit = unit;
    }

    public Amount() {
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "ingredient=" + ingredient +
                ", text='" + text + '\'' +
                ", unit=" + unit +
                '}';
    }
}
