package by.it.naumenko.project2.java.beens;

public class Zakaz {

    private long id_zakaz;
   // private long date_zakaz;
    private String tovar;
    private double priceHt;
    private double kolTovar;
    private String biscuit;
    private String nachinka;
    private String decoration;
    private String cream;
    private double price_zakaz;
    long id_user;
    long id_tovar;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    private String status;

    public long getId_zakaz() {
        return id_zakaz;
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

    public double getPrice_zakaz() {
        return price_zakaz;
    }

    public long getId_user() {
        return id_user;
    }

    public long getId_tovar() {
        return id_tovar;
    }

    public void setId_zakaz(long id_zakaz) {
        this.id_zakaz = id_zakaz;
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

    public void setPrice_zakaz(double price_zakaz) {
        this.price_zakaz = price_zakaz;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public void setId_tovar(long id_tovar) {
        this.id_tovar = id_tovar;
    }

    @Override
    public String toString() {
        return "Zakaz{" +
                "id_zakaz=" + id_zakaz +
                ", tovar='" + tovar + '\'' +
                ", priceHt=" + priceHt +
                ", kolTovar=" + kolTovar +
                ", biscuit='" + biscuit + '\'' +
                ", nachinka='" + nachinka + '\'' +
                ", decoration='" + decoration + '\'' +
                ", cream='" + cream + '\'' +
                ", price_zakaz=" + price_zakaz +
                ", id_user=" + id_user +
                ", id_tovar=" + id_tovar +
                ", status=" + status +
                '}';
    }

    public Zakaz(long id_zakaz,
                 String tovar,
                 double priceHt,
                 double kolTovar,
                 String biscuit,
                 String nachinka,
                 String decoration,
                 String cream,
                 double price_zakaz,
                 long id_user,
                 long id_tovar,
                 String status) {
        this.id_zakaz = id_zakaz;
        this.tovar = tovar;
        this.priceHt = priceHt;
        this.kolTovar = kolTovar;
        this.biscuit = biscuit;
        this.nachinka = nachinka;
        this.decoration = decoration;
        this.cream = cream;
        this.price_zakaz = price_zakaz;
        this.id_user = id_user;
        this.id_tovar = id_tovar;
        this.status = status;
    }

    public Zakaz() {
    }
}
