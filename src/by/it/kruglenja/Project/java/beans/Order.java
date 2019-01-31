package by.it.kruglenja.Project.java.beans;

public class Order {
    private long id;
    private int quanity;
    private String deliveryTime;
    private double totalPrice;
    private long spareParts_id;
    private long users_id;

    public Order() {
    }

    public Order(long id, int quanity, String deliveryTime, double totalPrice, long users_id, long spareParts_id) {
        this.id = id;
        this.quanity = quanity;
        this.deliveryTime = deliveryTime;
        this.totalPrice = totalPrice;
        this.users_id = users_id;
        this.spareParts_id = spareParts_id;
    }

    public long getSparePart_id() { return spareParts_id; }

    public void setSparePart_id(long spareParts_id) { this.spareParts_id = spareParts_id; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getQuanity() { return quanity; }

    public void setQuanity(int quanity) { this.quanity = quanity; }

    public String getDeliveryTime() { return deliveryTime; }

    public void setDeliveryTime(String deliveryTime) { this.deliveryTime = deliveryTime; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quanity=" + quanity +
                ", deliveryTime=" + deliveryTime +
                ", totalPrice=" + totalPrice +
                ", spareParts_id=" + spareParts_id +
                ", users_id=" + users_id +
                '}';
    }
}
