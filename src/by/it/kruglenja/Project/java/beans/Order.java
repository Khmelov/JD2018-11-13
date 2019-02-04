package by.it.kruglenja.Project.java.beans;

public class Order {
    private long id;
    private int quanity;
    private double totalPrice;
    private long spareParts_id;
    private long users_id;


    public Order() {
    }

    public Order(long id, int quanity, double totalPrice, long users_id, long spareParts_id) {
        this.id = id;
        this.quanity = quanity;
        this.totalPrice = totalPrice;
        this.users_id = users_id;
        this.spareParts_id = spareParts_id;
    }

    public long getSpareParts_id() { return spareParts_id; }

    public void setSpareParts_id(long spareParts_id) { this.spareParts_id = spareParts_id; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getQuanity() { return quanity; }

    public void setQuanity(int quanity) { this.quanity = quanity; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quanity=" + quanity +
                ", totalPrice=" + totalPrice +
                ", spareParts_id=" + spareParts_id +
                ", users_id=" + users_id +
                '}';
    }
}
