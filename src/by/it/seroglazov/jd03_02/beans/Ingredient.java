package by.it.seroglazov.jd03_02.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ingredient {
    private long id;
    private String name;
    private List<Itag> itags;

    public List<Itag> getItags() {
        return itags;
    }

    public void setItags(List<Itag> itags) {
        this.itags = itags;
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

    public Ingredient() {
    }

    public Ingredient(String name, Itag... itags) {
        this.name = name;
        if (itags.length > 0) {
            this.itags = Arrays.asList(itags);
        }
    }

    public Ingredient(long id, String name, List<Itag> itags) {
        this.id = id;
        this.name = name;
        this.itags = itags;
    }
}


