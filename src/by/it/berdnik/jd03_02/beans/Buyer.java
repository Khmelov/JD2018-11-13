package by.it.berdnik.jd03_02.beans;

public class Buyer {

    private long id;
    private String item;
    private String specif;
    private double price;
    private String address;
    private long users_Id;

    public Buyer() {
    }

    public Buyer(long id, String item, String specif, double price, String address, long users_Id) {
        this.id = id;
        this.item = item;
        this.specif = specif;
        this.price = price;
        this.address = address;
        this.users_Id = users_Id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSpecif() {
        return specif;
    }

    public void setSpecif(String specif) {
        this.specif = specif;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(long users_Id) {
        this.users_Id = users_Id;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", specif='" + specif + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", users_Id=" + users_Id +
                '}';
    }
}
