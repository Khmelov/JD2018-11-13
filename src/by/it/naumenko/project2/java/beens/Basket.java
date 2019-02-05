package by.it.naumenko.project2.java.beens;

public class Basket {

    private long id_basket;
    private String tovar;
    private double priceHt;
    private double kolTovar;
    private String biscuit;
    private String nachinka;
    private String decoration;
    private String cream;
    private double price_basket;
    long id_user;

    public long getId_basket() {
        return id_basket;
    }

    public String getTovar() {
        return tovar;
    }

    public double getPriceHt() {
        return priceHt;
    }

    public double getKolTovar() {
        return kolTovar;
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

    public double getPrice_basket() {
        return price_basket;
    }

    public long getId_user() {
        return id_user;
    }


    public void setId_basket(long id_basket) {
        this.id_basket = id_basket;
    }

    public void setTovar(String tovar) {
        this.tovar = tovar;
    }

    public void setPriceHt(double priceHt) {
        this.priceHt = priceHt;
    }

    public void setKolTovar(double kolTovar) {
        this.kolTovar = kolTovar;
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

    public void setPrice_basket(double price_basket) {
        this.price_basket = price_basket;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }


    @Override
    public String toString() {
        return "BASKET{" +
                "id_basket=" + id_basket +
                ", tovar='" + tovar + '\'' +
                ", priceHt=" + priceHt +
                ", kolTovar=" + kolTovar +
                ", biscuit='" + biscuit + '\'' +
                ", nachinka='" + nachinka + '\'' +
                ", decoration='" + decoration + '\'' +
                ", cream='" + cream + '\'' +
                ", price_basket=" + price_basket +
                ", id_user=" + id_user +
                '}';
    }

    public Basket(long id_basket,
                  String tovar,
                  double priceHt,
                  double kolTovar,
                  String biscuit,
                  String nachinka,
                  String decoration,
                  String cream,
                  double price_basket,
                  long id_user) {
        this.id_basket = id_basket;
        this.tovar = tovar;
        this.priceHt = priceHt;
        this.kolTovar = kolTovar;
        this.biscuit = biscuit;
        this.nachinka = nachinka;
        this.decoration = decoration;
        this.cream = cream;
        this.price_basket = price_basket;
        this.id_user = id_user;
    }

    public Basket() {
    }
}
