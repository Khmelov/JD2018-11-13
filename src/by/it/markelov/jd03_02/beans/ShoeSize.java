package by.it.markelov.jd03_02.beans;

import java.util.Objects;

public class ShoeSize {
    private int id;
    private double shoeSize;
    private int orders_ID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }

    public int getOrders_ID() {
        return orders_ID;
    }

    public void setOrders_ID(int orders_ID) {
        this.orders_ID = orders_ID;
    }

    public ShoeSize(int id, double shoeSize, int orders_ID) {
        this.id = id;
        this.shoeSize = shoeSize;
        this.orders_ID = orders_ID;
    }

    public ShoeSize() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoeSize shoeSize1 = (ShoeSize) o;
        return id == shoeSize1.id &&
                Double.compare(shoeSize1.shoeSize, shoeSize) == 0 &&
                orders_ID == shoeSize1.orders_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoeSize, orders_ID);
    }

    @Override
    public String toString() {
        return "ShoeSize{" +
                "id=" + id +
                ", shoeSize=" + shoeSize +
                ", orders_ID=" + orders_ID +
                '}';
    }
}
