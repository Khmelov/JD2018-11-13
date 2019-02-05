package by.it.denisova.project.java.beans;

public class TypeLesson {
    private long id;
    private String type;

    public TypeLesson() {
    }

    public TypeLesson(long id, String type) {
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
        return "TypeLesson{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
