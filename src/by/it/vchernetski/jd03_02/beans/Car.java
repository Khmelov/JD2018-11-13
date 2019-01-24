package by.it.vchernetski.jd03_02.beans;

public class Car {
    private long id;
    private String model;
    private String color;
    private int year;
    private long garages_id;

    public Car() {
    }


    public Car(long id, String model, String color, int year, long garages_id) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.year = year;
        this.garages_id = garages_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getGarages_id() {
        return garages_id;
    }

    public void setGarages_id(long garages_id) {
        this.garages_id = garages_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id + '\'' +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", garages_id=" + garages_id +
                '}';
    }
}
