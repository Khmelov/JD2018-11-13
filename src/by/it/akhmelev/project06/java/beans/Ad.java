package by.it.akhmelev.project06.java.beans;

public class Ad {

    private long id;
    private String description;
    private String address;
    private int floor;
    private int floors;
    private int rooms;
    private double area;
    private double price;
    private long users_id;

    public Ad() {
    }

    public Ad(long id, String description, String address, int floor, int floors, int rooms, double area, double price, long users_id) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.floor = floor;
        this.floors = floors;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.users_id = users_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                ", users_id=" + users_id +
                '}';
    }
}
