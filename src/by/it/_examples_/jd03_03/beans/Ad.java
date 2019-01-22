package by.it._examples_.jd03_03.beans;

public class Ad {

    private int ID;
    private int RoomCount;
    private double Price;
    private double Area;
    private int Floor;
    private int Floors;
    private String Address;
    private String Description;
    private int FK_Users;

    public Ad() {
    }

    public Ad(int ID, int roomCount, double price, double area, int floor, int floors, String address, String description, int FK_Users) {
        this.ID = ID;
        RoomCount = roomCount;
        Price = price;
        Area = area;
        Floor = floor;
        Floors = floors;
        Address = address;
        Description = description;
        this.FK_Users = FK_Users;
    }


    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoomCount() {
        return RoomCount;
    }

    public void setRoomCount(int roomCount) {
        RoomCount = roomCount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getArea() {
        return Area;
    }

    public void setArea(double area) {
        Area = area;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public int getFloors() {
        return Floors;
    }

    public void setFloors(int floors) {
        Floors = floors;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", RoomCount=" + RoomCount +
                ", Price=" + Price +
                ", Area=" + Area +
                ", Floor=" + Floor +
                ", Floors=" + Floors +
                ", Address='" + Address + '\'' +
                ", Description='" + Description + '\'' +
                ", FK_Users=" + FK_Users +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (ID != ad.ID) return false;
        if (RoomCount != ad.RoomCount) return false;
        if (Double.compare(ad.Price, Price) != 0) return false;
        if (Double.compare(ad.Area, Area) != 0) return false;
        if (Floor != ad.Floor) return false;
        if (Floors != ad.Floors) return false;
        if (FK_Users != ad.FK_Users) return false;
        if (Address != null ? !Address.equals(ad.Address) : ad.Address != null) return false;
        return Description != null ? Description.equals(ad.Description) : ad.Description == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ID;
        result = 31 * result + RoomCount;
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Floor;
        result = 31 * result + Floors;
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        result = 31 * result + FK_Users;
        return result;
    }
}
