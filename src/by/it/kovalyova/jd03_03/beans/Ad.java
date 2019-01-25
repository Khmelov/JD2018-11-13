package by.it.kovalyova.jd03_03.beans;

public class Ad {
    private long id;
    private  String description;
    private String adress;
    private int floor;
    private int floors;
    private  int rooms;
    private double area;
    private double price;
    private long user_id;


    public Ad(){
    }

    public Ad(long id, String description, String address, int floor, int floors, int rooms, double area, double price, long user_id) {
        this.id = id;
        this.description = description;
        this.adress = adress;
        this.floor = floor;
        this.floors = floors;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.user_id = user_id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public long getUser_id() { return user_id; }

    public void setUser_id(long user_id) { this.user_id = user_id; }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", adress='" + adress + '\'' +
                ", floor=" + floor +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                ", user_id=" + user_id +
                '}';
    }
}

