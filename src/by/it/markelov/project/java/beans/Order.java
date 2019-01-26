package by.it.markelov.project.java.beans;

import java.util.Objects;

public class Order {
    private int id;
    private String shoeName;
    private int shoeSize;
    private String shoeColour;
    private double price;
    private int users_ID;

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

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getShoeColour() {
        return shoeColour;
    }

    public void setShoeColour(String shoeColour) {
        this.shoeColour = shoeColour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public Order(int id, String shoeName, int shoeSize, String shoeColour, double price, int users_ID) {
        this.id = id;
        this.shoeName = shoeName;
        this.shoeSize = shoeSize;
        this.shoeColour = shoeColour;
        this.price = price;
        this.users_ID = users_ID;
    }

    public Order() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                shoeSize == order.shoeSize &&
                Double.compare(order.price, price) == 0 &&
                users_ID == order.users_ID &&
                Objects.equals(shoeName, order.shoeName) &&
                Objects.equals(shoeColour, order.shoeColour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoeName, shoeSize, shoeColour, price, users_ID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shoeName='" + shoeName + '\'' +
                ", shoeSize=" + shoeSize +
                ", shoeColour='" + shoeColour + '\'' +
                ", price=" + price +
                ", users_ID=" + users_ID +
                '}';
    }
}
