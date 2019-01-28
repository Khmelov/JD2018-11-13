package by.it.naumenko.jd03_02.beens;

public class Cake {

    private long id_cake;
    private String name_cake;
    private int size_cake;
    private double weight_cake;
    private String bescuit;
    private String decoration;
    private String cream;
    private double price_cake;

    public Cake(long id_cake,
                String name_cake,
                int size_cake,
                double weight_cake,
                String bescuit,
                String decoration,
                String cream,
                double price_cake) {
        this.id_cake = id_cake;
        this.name_cake = name_cake;
        this.size_cake = size_cake;
        this.weight_cake = weight_cake;
        this.bescuit = bescuit;
        this.decoration = decoration;
        this.cream = cream;
        this.price_cake = price_cake;
    }

    public Cake() {
    }

    public void setId_cake(long id_cake) {
        this.id_cake = id_cake;
    }

    public void setName_cake(String name_cake) {
        this.name_cake = name_cake;
    }

    public void setSize_cake(int size_cake) {
        this.size_cake = size_cake;
    }

    public void setWeight_cake(double weight_cake) {
        this.weight_cake = weight_cake;
    }

    public void setBescuit(String bescuit) {
        this.bescuit = bescuit;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public void setCream(String cream) {
        this.cream = cream;
    }

    public void setPrice_cake(double price_cake) {
        this.price_cake = price_cake;
    }

    public long getId_cake() {
        return id_cake;
    }

    public String getName_cake() {
        return name_cake;
    }

    public int getSize_cake() {
        return size_cake;
    }

    public double getWeight_cake() {
        return weight_cake;
    }

    public String getBescuit() {
        return bescuit;
    }

    public String getDecoration() {
        return decoration;
    }

    public String getCream() {
        return cream;
    }

    public double getPrice_cake() {
        return price_cake;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id_cake=" + id_cake +
                ", name_cake='" + name_cake + '\'' +
                ", size_cake=" + size_cake +
                ", weight_cake=" + weight_cake +
                ", bescuit='" + bescuit + '\'' +
                ", decoration='" + decoration + '\'' +
                ", cream='" + cream + '\'' +
                ", price_cake=" + price_cake +
                '}';
    }
}
