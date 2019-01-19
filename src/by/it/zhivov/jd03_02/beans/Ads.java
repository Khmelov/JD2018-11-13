package by.it.zhivov.jd03_02.beans;

public class Ads {
    private long id;
    private String title;
    private String description;
    private String brand;
    private String model;
    private long id_User;

    public Ads() {
    }

    public Ads(long id, String title, String description, String brand, String model, long id_User) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.model = model;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId_User() {
        return id_User;
    }

    public void setId_User(long id_User) {
        this.id_User = id_User;
    }
}
