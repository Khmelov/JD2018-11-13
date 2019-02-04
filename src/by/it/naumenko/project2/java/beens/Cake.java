package by.it.naumenko.project2.java.beens;

public class Cake {

    private long id_tovar;
    private String kategoriya;
    private double price;
    private String biscuit;
    private String nachinka;
    private String decoration;
    private String cream;

    public void setId_tovar(long id_tovar) {
        this.id_tovar = id_tovar;
    }

    public void setKategoriya(String kategoriya) {
        this.kategoriya = kategoriya;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBiscuit(String biscuit) {
        this.biscuit = biscuit;
    }

    public void setNachinka(String nachinka) {
        this.nachinka = nachinka;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public void setCream(String cream) {
        this.cream = cream;
    }

    public long getId_tovar() {
        return id_tovar;
    }

    public String getKategoriya() {
        return kategoriya;
    }

    public double getPrice() {
        return price;
    }

    public String getBiscuit() {
        return biscuit;
    }

    public String getNachinka() {
        return nachinka;
    }

    public String getDecoration() {
        return decoration;
    }

    public String getCream() {
        return cream;
    }

    public Cake() {
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id_tovar=" + id_tovar +
                ", kategoriya='" + kategoriya + '\'' +
                ", price=" + price +
                ", biscuit='" + biscuit + '\'' +
                ", nachinka='" + nachinka + '\'' +
                ", decoration='" + decoration + '\'' +
                ", cream='" + cream + '\'' +
                '}'+"\n";
    }

    public Cake(long id_tovar,
                String kategoriya,
                double price,
                String biscuit,
                String nachinka,
                String decoration,
                String cream) {
        this.id_tovar = id_tovar;
        this.kategoriya = kategoriya;
        this.price = price;
        this.biscuit = biscuit;
        this.nachinka = nachinka;
        this.decoration = decoration;
        this.cream = cream;
    }
}
