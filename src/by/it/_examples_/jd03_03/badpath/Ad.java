package by.it._examples_.jd03_03.badpath;

import java.io.Serializable;

public class Ad implements Serializable{

    private int id;
    private String description;
    private String address;
    private int floor;
    private int floors;
    private int roomCount;
    private double price;
    private double area;
    private int fk_users;

    public Ad() {
    }

    public Ad(int id, String description, String address, int floor, int floors, int roomCount, double price, double area, int fk_users) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.floor = floor;
        this.floors = floors;
        this.roomCount = roomCount;
        this.price = price;
        this.area = area;
        this.fk_users = fk_users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
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

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getFk_users() {
        return fk_users;
    }

    public void setFk_users(int fk_users) {
        this.fk_users = fk_users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (id != ad.id) return false;
        if (floor != ad.floor) return false;
        if (floors != ad.floors) return false;
        if (roomCount != ad.roomCount) return false;
        if (Double.compare(ad.price, price) != 0) return false;
        if (Double.compare(ad.area, area) != 0) return false;
        if (fk_users != ad.fk_users) return false;
        if (description != null ? !description.equals(ad.description) : ad.description != null) return false;
        return address != null ? address.equals(ad.address) : ad.address == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + floor;
        result = 31 * result + floors;
        result = 31 * result + roomCount;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + fk_users;
        return result;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", floors=" + floors +
                ", roomCount=" + roomCount +
                ", price=" + price +
                ", area=" + area +
                ", fk_users=" + fk_users +
                '}';
    }
}
