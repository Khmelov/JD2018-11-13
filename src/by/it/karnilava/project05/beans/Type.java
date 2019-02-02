package by.it.karnilava.project05.beans;

public class Type {
    private long id;
    private String type;

    public Type() {
    }

    public Type(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}

