package by.it.skarpovich.jd03_03.beans;

public class Item {
    private int id;
    private String title;
    private int floors;
    private int square;
    private String materials;
    private int price;

    public Item() {
    }

    public Item(int id, String title, int floors, int square, String materials, int price) {
        this.id = id;
        this.title = title;
        this.floors = floors;
        this.square = square;
        this.materials = materials;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", floors=" + floors +
                ", square=" + square +
                ", materials='" + materials + '\'' +
                ", price=" + price +
                '}';
    }
}
