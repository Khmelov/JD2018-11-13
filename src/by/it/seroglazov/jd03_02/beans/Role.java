package by.it.seroglazov.jd03_02.beans;

public class Role {
    private long id;
    private String name;

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

    public Role() {

    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
