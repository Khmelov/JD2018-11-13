package by.it.markelov.jd03_02.beans;

import java.util.Objects;

public class ShoeName {
    private int id;
    private String shoeName;
    private int orders_ID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public int getOrders_ID() {
        return orders_ID;
    }

    public void setOrders_ID(int orders_ID) {
        this.orders_ID = orders_ID;
    }

    public ShoeName(int id, String shoeName, int orders_ID) {
        this.id = id;
        this.shoeName = shoeName;
        this.orders_ID = orders_ID;
    }

    public ShoeName() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoeName shoeName1 = (ShoeName) o;
        return id == shoeName1.id &&
                orders_ID == shoeName1.orders_ID &&
                Objects.equals(shoeName, shoeName1.shoeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoeName, orders_ID);
    }

    @Override
    public String toString() {
        return "ShoeName{" +
                "id=" + id +
                ", shoeName='" + shoeName + '\'' +
                ", orders_ID=" + orders_ID +
                '}';
    }
}
