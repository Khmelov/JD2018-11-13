package by.it.kruglenja.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer extends Thread implements IBuyer {

    Backet backet = new Backet();
    int customerNumber;

    public Buyer(int num) {
        super("Покупатель №" + num);
        customerNumber = num;
    }

    public int getCustomerNumber() { return customerNumber; }

    @Override
    public void run() {
        enterToMarket();
        backet.takeBacket(customerNumber);
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName() + ": ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {

        System.out.println(this + "выбирает товар");
        backet.putGoodsToBacket(customerNumber);
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void goOut() {
        System.out.println(this + "отправился на выход");
    }
}
