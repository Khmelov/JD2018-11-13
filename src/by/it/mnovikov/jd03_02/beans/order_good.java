package by.it.mnovikov.jd03_02.beans;

public class order_good {
    private int orders_id;
    private int goods_id;

    public order_good() {
    }

    public order_good(int orders_id, int goods_id) {
        this.orders_id = orders_id;
        this.goods_id = goods_id;
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

        order_good that = (order_good) o;

        if (orders_id != that.orders_id) return false;
        return goods_id == that.goods_id;
    }

    @Override
    public int hashCode() {
        int result = orders_id;
        result = 31 * result + goods_id;
        return result;
    }

    @Override
    public String toString() {
        return "order_good{" +
                "orders_id=" + orders_id +
                ", goods_id=" + goods_id +
                '}';
    }
}
