package by.it.kruglenja.Project.java.beans;

public class Order {
    private long id;
    private int quanity;
    private String model;
    private String name;
    private double price;
    private long users_id;
    private long spareParts_id;


    public Order() {
    }

    public Order(long id, int quanity, String model, String name, double price, long spareParts_id, long users_id) {
        this.id = id;
        this.quanity = quanity;
        this.model = model;
        this.name = name;
        this.price = price;
        this.spareParts_id = spareParts_id;
        this.users_id = users_id;
    }

    public long getSpareParts_id() { return spareParts_id; }

    public void setSpareParts_id(long spareParts_id) { this.spareParts_id = spareParts_id; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getQuanity() { return quanity; }

    public void setQuanity(int quanity) { this.quanity = quanity; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quanity=" + quanity +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", spareParts_id=" + spareParts_id +
                ", users_id=" + users_id +
                '}';
    }
}
