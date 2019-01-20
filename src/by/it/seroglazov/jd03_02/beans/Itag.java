package by.it.seroglazov.jd03_02.beans;

import java.util.List;

public class Itag {
    private long id;
    private String text;

    public Itag(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Itag(String text) {
        this.text = text;
    }

    public Itag() {
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
}
