package by.it.denisova.project.java.beans;

public class Lesson {
    private long id;
    private String theory;
    private long id_theme;
    private long id_test;
    private long id_type;

    public Lesson() {
    }

    public Lesson(long id, String theory, long id_theme, long id_test, long id_type) {
        this.id = id;
        this.theory = theory;
        this.id_theme = id_theme;
        this.id_test = id_test;
        this.id_type = id_type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public long getId_theme() {
        return id_theme;
    }

    public void setId_theme(long id_theme) {
        this.id_theme = id_theme;
    }

    public long getId_test() {
        return id_test;
    }

    public void setId_test(long id_test) {
        this.id_test = id_test;
    }

    public long getId_type() {
        return id_type;
    }

    public void setId_type(long id_type) {
        this.id_type = id_type;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", theory='" + theory + '\'' +
                ", id_theme=" + id_theme +
                ", id_test=" + id_test +
                ", id_type=" + id_type +
                '}';
    }
}
