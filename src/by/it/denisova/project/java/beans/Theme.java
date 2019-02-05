package by.it.denisova.project.java.beans;

public class Theme {
 private long id;
 private String theme;

    public Theme() {
    }

    public Theme(long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                '}';
    }
}
