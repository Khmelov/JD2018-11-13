package by.it.seroglazov.project.java.beans;

@SuppressWarnings("unused")
public class Unit {
    private long id;
    private String name;

    public Unit(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Unit(String name) {
        this.name = name;
    }

    public Unit() {
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

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
