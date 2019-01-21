package by.it.seroglazov.jd03_02.beans;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Recipe {
    private long id;
    private String name;
    private Rtype rtype;
    private String description;
    private List<Amount> amounts;

    public Recipe() {
        this.amounts = new LinkedList<>();
    }

    public Recipe(String name, Rtype rtype, String description, List<Amount> amounts) {
        this.name = name;
        this.rtype = rtype;
        this.description = description;
        this.amounts = amounts;
    }

    public Recipe(long id, String name, Rtype rtype, String description, List<Amount> amounts) {
        this.id = id;
        this.name = name;
        this.rtype = rtype;
        this.description = description;
        this.amounts = amounts;
    }

    public Recipe(String name, Rtype rtype, String description, Amount... amounts) {
        this.name = name;
        this.rtype = rtype;
        this.description = description;
        if (amounts.length > 0) {
            this.amounts = Arrays.asList(amounts);
        } else
            this.amounts = new LinkedList<>();
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

    public Rtype getRtype() {
        return rtype;
    }

    public void setRtype(Rtype rtype) {
        this.rtype = rtype;
    }

    public List<Amount> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Amount> amounts) {
        this.amounts = amounts;
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
                ", rtype=" + rtype +
                "\ndescription='" + description + '\'' +
                "\namounts=" + amounts +
                '}';
    }
}


