package by.it.mnovikov.jd03_03.beans;

import java.sql.Timestamp;

public class Order {

    private int id;
    private Timestamp date;
    private int users_ID;

    public Order() {
    }

    public Order(int id, Timestamp date, int users_ID) {
        this.id = id;
        this.date = date;
        this.users_ID = users_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (users_ID != order.users_ID) return false;
        return date != null ? date.equals(order.date) : order.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + users_ID;
        return result;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", users_ID=" + users_ID +
                '}';
    }
}