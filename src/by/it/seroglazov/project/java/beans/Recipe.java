package by.it.seroglazov.project.java.beans;


@SuppressWarnings("unused")
public class Recipe {
    private long id;
    private String name;
    private long rtype_id;
    private String description;

    public Recipe(long id, String name, long rtype_id, String description) {
        this.id = id;
        this.name = name;
        this.rtype_id = rtype_id;
        this.description = description;
    }

    public Recipe(String name, long rtype_id, String description) {
        this.name = name;
        this.rtype_id = rtype_id;
        this.description = description;
    }

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRtype_id() {
        return rtype_id;
    }

    public void setRtype_id(long rtype_id) {
        this.rtype_id = rtype_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rtype_id=" + rtype_id +
                ", description='" + description + '\'' +
                '}';
    }
}


