package by.it.seroglazov.jd03_02.beans;

public class Rtype {
    private long id;
    private String text;

    public Rtype() {
    }

    public Rtype(String text) {
        this.text = text;
    }

    public Rtype(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Rtype{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
