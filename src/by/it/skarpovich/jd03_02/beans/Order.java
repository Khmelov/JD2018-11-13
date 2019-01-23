package by.it.skarpovich.jd03_02.beans;

public class Order {

    private int id;
    private String date;
    private String time;
    private int users_id;
    private int items_id;

    public Order() {
    }

    public Order(int id, String date, String time, int users_id, int items_id) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.users_id = users_id;
        this.items_id = items_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", users_id=" + users_id +
                ", items_id=" + items_id +
                '}';
    }
}