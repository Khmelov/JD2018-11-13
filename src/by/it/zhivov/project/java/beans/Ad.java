package by.it.zhivov.project.java.beans;

public class Ad {
    private long id;
    private String title;
    private String description;
    private String brnd;
    private String model;
    private String color;
    private String body;
    private int year;
    private double engine;
    private int at;
    private String driveunit;
    private String equipment;
    private int millage;
    private int crashed;
    private double price;
    private long id_User;

    public Ad() {
    }

    public Ad(long id, String title, String description, String brnd, String model, String color, String body, int year, double engine, int at, String driveunit, String equipment, int millage, int crashed, double price, long id_User) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.brnd = brnd;
        this.model = model;
        this.color = color;
        this.body = body;
        this.year = year;
        this.engine = engine;
        this.at = at;
        this.driveunit = driveunit;
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

    public void setBrnd(String brnd) {
        this.brnd = brnd;
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

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public int getAt() {
        return at;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public String getDriveunit() {
        return driveunit;
    }

    public void setDriveunit(String driveunit) {
        this.driveunit = driveunit;
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

    public int isCrashed() {
        return crashed;
    }

    public void setCrashed(int crashed) {
        this.crashed = crashed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return "<br>Ad{" +
                "id=" + id + "\n<br>" +
                ", title='" + title + '\'' + "\n<br>" +
                ", description='" + description + '\'' + "\n<br>" +
                ", brnd='" + brnd + '\'' + "\n<br>" +
                ", model='" + model + '\'' + "\n<br>" +
                ", color='" + color + '\'' + "\n<br>" +
                ", body='" + body + '\'' + "\n<br>" +
                ", year=" + year + "\n<br>" +
                ", engine=" + engine + "\n<br>" +
                ", at=" + at + "\n<br>" +
                ", driveunit='" + driveunit + '\'' + "\n<br>" +
                ", equipment='" + equipment + '\'' + "\n<br>" +
                ", millage=" + millage + "\n<br>" +
                ", crashed=" + crashed + "\n<br>" +
                ", price=" + price + "\n<br>" +
                ", users_id=" + id_User +
                '}';
    }
}
