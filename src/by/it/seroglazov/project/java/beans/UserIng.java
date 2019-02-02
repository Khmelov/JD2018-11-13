package by.it.seroglazov.project.java.beans;

public class Usering {
    private long id;
    private long user_id;
    private long ingredient_id;

    public Usering() {
    }

    public Usering(long user_id, long ingredient_id) {
        this.user_id = user_id;
        this.ingredient_id = ingredient_id;
    }

    public Usering(long id, long user_id, long ingredient_id) {
        this.id = id;
        this.user_id = user_id;
        this.ingredient_id = ingredient_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    @Override
    public String toString() {
        return "UserIng{" +
                "user_id=" + user_id +
                ", ingredient_id=" + ingredient_id +
                '}';
    }
}
