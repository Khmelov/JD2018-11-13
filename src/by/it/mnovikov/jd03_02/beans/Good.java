package by.it.mnovikov.jd03_02.beans;

public class Good {

    private int id;
    private String title;
    private String discription;
    private String type;
    private double productivity;
    private double price;

    public Good() {
    }

    public Good(int id, String title, String discription, String type, double productivity, double price) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.type = type;
        this.productivity = productivity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (id != good.id) return false;
        if (Double.compare(good.productivity, productivity) != 0) return false;
        if (Double.compare(good.price, price) != 0) return false;
        if (title != null ? !title.equals(good.title) : good.title != null) return false;
        if (discription != null ? !discription.equals(good.discription) : good.discription != null) return false;
        return type != null ? type.equals(good.type) : good.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(productivity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", type='" + type + '\'' +
                ", productivity=" + productivity +
                ", price=" + price +
                '}';
    }
}