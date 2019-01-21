package by.it.mnovikov.jd03_02.beans;

import java.util.HashSet;
import java.util.Set;

public class Order {

    private int id;
    private String date;
    private String time;
    private int users_ID;
    private Set<Goods> goods = new HashSet<>();

    public Order() {
    }

    public Order(int id, String date, String time, int users_ID, Set<Goods> goods) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.users_ID = users_ID;
        this.goods = goods;
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

    public int getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (users_ID != order.users_ID) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (time != null ? !time.equals(order.time) : order.time != null) return false;
        return goods != null ? goods.equals(order.goods) : order.goods == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + users_ID;
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", users_ID=" + users_ID +
                ", goods=" + goods +
                '}';
    }
}
