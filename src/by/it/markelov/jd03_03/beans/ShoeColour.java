package by.it.markelov.jd03_03.beans;

import java.util.Objects;

public class ShoeColour {
    private int id;
    private String shoeColour;
    private int orders_ID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoeColour() {
        return shoeColour;
    }

    public void setShoeColour(String shoeColour) {
        this.shoeColour = shoeColour;
    }

    public int getOrders_ID() {
        return orders_ID;
    }

    public void setOrders_ID(int orders_ID) {
        this.orders_ID = orders_ID;
    }

    public ShoeColour(int id, String shoeColour, int orders_ID) {
        this.id = id;
        this.shoeColour = shoeColour;
        this.orders_ID = orders_ID;
    }

    public ShoeColour() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoeColour colour = (ShoeColour) o;
        return id == colour.id &&
                orders_ID == colour.orders_ID &&
                Objects.equals(shoeColour, colour.shoeColour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoeColour, orders_ID);
    }

    @Override
    public String toString() {
        return "Colour{" +
                "id=" + id +
                ", shoeColour='" + shoeColour + '\'' +
                ", orders_ID=" + orders_ID +
                '}';
    }
}
