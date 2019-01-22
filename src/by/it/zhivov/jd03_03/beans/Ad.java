package by.it.zhivov.jd03_03.beans;

public class Ad {
    private long id;
    private String title;
    private String description;
    private String brnd;
    private String model;
    private String color;
    private String body;
    private int year;
    private String equipment;
    private int millage;
    private boolean crashed;
    private int price;
    private long id_User;

    public Ad() {
    }

    public Ad(long id, String title, String description, String brnd, String model, String color, String body, int year, String equipment, int millage, boolean crashed, int price, long id_User) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.brnd = brnd;
        this.model = model;
        this.color = color;
        this.body = body;
        this.year = year;
        this.equipment = equipment;
        this.millage = millage;
        this.crashed = crashed;
        this.price = price;
        this.id_User = id_User;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrnd() {
        return brnd;
    }

    public void setBrnd(String brand) {
        this.brnd = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId_User() {
        return id_User;
    }

    public void setId_User(long id_User) {
        this.id_User = id_User;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brnd + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", body='" + body + '\'' +
                ", year=" + year +
                ", equipment='" + equipment + '\'' +
                ", millage=" + millage +
                ", crashed=" + crashed +
                ", price=" + price +
                ", id_User=" + id_User +
                '}';
    }
}
