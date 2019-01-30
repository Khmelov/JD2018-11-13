package by.it.kruglenja.jd03_03.beans;

public class Order {
    private long id;
    private int quanity;
    private String deliveryTime;
    private double totalPrice;
    private long users_id;

    public Order() {
    }

    public Order(long id, int quanity, String deliveryTime, double totalPrice, long users_id) {
        this.id = id;
        this.quanity = quanity;
        this.deliveryTime = deliveryTime;
        this.totalPrice = totalPrice;
        this.users_id = users_id;
    }

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
        return "order{" +
                "id=" + id +
                ", quanity=" + quanity +
                ", deliveryTime=" + deliveryTime +
                ", totalPrice=" + totalPrice +
                ", users_id=" + users_id +
                '}';
    }
}
