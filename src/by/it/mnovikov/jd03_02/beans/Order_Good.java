package by.it.mnovikov.jd03_02.beans;

public class Order_Good {
    private int id;
    private int orders_id;
    private int goods_id;

    public Order_Good() {
    }

    public Order_Good(int id, int orders_id, int goods_id) {
        this.id = id;
        this.orders_id = orders_id;
        this.goods_id = goods_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order_Good that = (Order_Good) o;

        if (id != that.id) return false;
        if (orders_id != that.orders_id) return false;
        return goods_id == that.goods_id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orders_id;
        result = 31 * result + goods_id;
        return result;
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", goods_id=" + goods_id +
                '}';
    }
}
