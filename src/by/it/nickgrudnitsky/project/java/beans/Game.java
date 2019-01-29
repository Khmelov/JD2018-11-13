package by.it.nickgrudnitsky.project.java.beans;

public class Game {
    private long id;
    private String game;
    private String link;

    public Game() {
    }

    public Game(String game, String link) {
        this.game = game;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
