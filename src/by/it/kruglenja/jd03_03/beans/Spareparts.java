package by.it.kruglenja.jd03_03.beans;

public class Spareparts {
    private long id;
    private String model;
    private String category;
    private String name;
    private String serial_number;
    private double weight;
    private double price;

    public Spareparts() {
    }

    public Spareparts(long id, String model, String category, String name, String serial_number, double weight, double price) {
        this.id = id;
        this.model = model;
        this.category = category;
        this.name = name;
        this.serial_number = serial_number;
        this.weight = weight;
        this.price = price;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSerial_number() { return serial_number; }

    public void setSerial_number(String serial_number) { this.serial_number = serial_number; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Spareparts{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", serial_number='" + serial_number + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}

