package by.it.kovalyova.jd03_03.beans;

public class Ad {
    private long id;
    private  String price;
    private long flats_id;
    private long users_id;


    public Ad(){
    }

    public Ad(long id, String price, long flats_id, long users_id) {
        this.id = id;
        this.price = price;
        this.flats_id = flats_id;
        this.users_id = users_id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public long getFlats_id() { return flats_id; }

    public void setFlats_id(long users_id) { this.flats_id = flats_id; }

    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}

