package by.it.mnovikov.jd03_02.beans;

import java.util.HashSet;
import java.util.Set;

public class Goods {

    private int id;
    private String title;
    private String discription;
    private String type;
    private double productivity;
    private double price;
    private Set<Order> orders = new HashSet<>();

    public Goods() {
    }

    public Goods(int id, String title, String discription, String type,
                 double productivity, double price, Set<Order> orders) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.type = type;
        this.productivity = productivity;
        this.price = price;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (Double.compare(goods.productivity, productivity) != 0) return false;
        if (Double.compare(goods.price, price) != 0) return false;
        if (title != null ? !title.equals(goods.title) : goods.title != null) return false;
        if (discription != null ? !discription.equals(goods.discription) : goods.discription != null) return false;
        if (type != null ? !type.equals(goods.type) : goods.type != null) return false;
        return orders != null ? orders.equals(goods.orders) : goods.orders == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(productivity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", type='" + type + '\'' +
                ", productivity=" + productivity +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }
}
