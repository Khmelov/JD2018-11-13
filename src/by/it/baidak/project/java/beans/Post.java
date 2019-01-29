package by.it.baidak.project.java.beans;

public class Post {

    private long id;
    private long userID;
    private String head;
    private String date;

    public Post() {
    }

    public Post(long id, long userID, String head, String date) {
        this.id = id;
        this.userID = userID;
        this.head = head;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userID=" + userID +
                ", head='" + head + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
