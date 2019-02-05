package by.it.kruglenja.Project.java.beans;

public class CompletedOrder {
    long id;
    String address;
    String info;
    double totalPrice;
    long users_id;

    public CompletedOrder() {
    }

    public CompletedOrder(long id, String address, String info, double totalPrice, long users_id) {
        this.id = id;
        this.address = address;
        this.info = info;
        this.totalPrice = totalPrice;
        this.users_id = users_id;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "CompletedOrder{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", info='" + info + '\'' +
                ", totalPrice=" + totalPrice +
                ", users_id=" + users_id +
                '}';
    }
}
