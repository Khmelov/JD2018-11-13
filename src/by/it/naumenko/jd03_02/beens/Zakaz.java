package by.it.naumenko.jd03_02.beens;

public class Zakaz {

    private long id_zakaz;
    private long date_zakaz;
    private String date_zakazS;
    private int koltort;
    private double price_zakaz;
    private long id_user;
    private long id_cake;

    public void setDate_zakazS(String date_zakazS) {
        this.date_zakazS = date_zakazS;
    }

    public String getDate_zakazS() {
        return date_zakazS;
    }

    public Zakaz(long id_zakaz,
                 String date_zakazS,
                 int koltort,
                 double price_zakaz,
                 long id_user,
                 long id_cake) {
        this.id_zakaz = id_zakaz;
        this.date_zakazS = date_zakazS;
        this.koltort = koltort;
        this.price_zakaz = price_zakaz;
        this.id_user = id_user;
        this.id_cake = id_cake;
    }



    public Zakaz(long id_zakaz,
                 long date_zakaz,
                 int koltort,
                 double price_zakaz,
                 long id_user,
                 long id_cake) {
        this.id_zakaz = id_zakaz;
        this.date_zakaz = date_zakaz;
        this.koltort = koltort;
        this.price_zakaz = price_zakaz;
        this.id_user = id_user;
        this.id_cake = id_cake;
    }

    @Override
    public String toString() {
        return "Zakaz{" +
                "id_zakaz=" + id_zakaz +
                ", date_zakaz=" + date_zakazS +
                ", koltort=" + koltort +
                ", price_zakaz=" + price_zakaz +
                ", id_user=" + id_user +
                ", id_cake=" + id_cake +
                '}';
    }

    public void setId_zakaz(long id_zakaz) {
        this.id_zakaz = id_zakaz;
    }

    public void setDate_zakaz(long date_zakaz) {
        this.date_zakaz = date_zakaz;
    }

    public void setKoltort(int koltort) {
        this.koltort = koltort;
    }

    public void setPrice_zakaz(double price_zakaz) {
        this.price_zakaz = price_zakaz;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public void setId_cake(long id_cake) {
        this.id_cake = id_cake;
    }

    public long getId_zakaz() {
        return id_zakaz;
    }

    public long getDate_zakaz() {
        return date_zakaz;
    }

    public int getKoltort() {
        return koltort;
    }

    public double getPrice_zakaz() {
        return price_zakaz;
    }

    public long getId_user() {
        return id_user;
    }

    public long getId_cake() {
        return id_cake;
    }

    public Zakaz() {
    }
}
