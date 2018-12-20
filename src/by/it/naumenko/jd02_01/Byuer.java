package by.it.naumenko.jd02_01;

import java.util.HashMap;

public class Byuer extends Thread implements IByuer, IUseBacked {

   public static boolean pensioneer;
    @Override
    public void enterToMArket() {
        if(!pensioneer)
            System.out.println(this + "вошел в магазин");
        else
            System.out.println(this + "вошел в магазин, он пенсионер");
    }

    @Override
    public void chooseGoods() {
        if (!pensioneer) {
            System.out.println(this + "Начал выбирать товар");
            Util.sleep(Util.random(500, 2000));
            System.out.println(this + "Выбрал товар");
        }
        else{
            System.out.println(this + "(пенсионер) Начал выбирать товар");
            Util.sleep((int) ((Util.random(500, 2000))*1.5));
            System.out.println(this + "(пенсионер) Выбрал товар");
        }
    }

    @Override
    public void goOut() {
        if (!pensioneer)
            System.out.println(this + "Вышел из магазина");
        else
            System.out.println(this + "(пенсионер) Вышел из магазина");

    }

    public void run() {
        enterToMArket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public String toString() {
        return super.getName();
    }

    Byuer(int number) {
        super("Покупатель № " + number + " ");
    }

    @Override
    public void takeBacket() {
        if (!pensioneer) {
            Util.sleep(Util.random(100, 200));
            System.out.println(this + "Взял корзину");
        }
        else
        {
            Util.sleep(Util.random(100, 200));
            System.out.println(this + "(пенсионер) Взял корзину");
        }


    }

    @Override
    public void putGoodsToBacket() {
        if (!pensioneer) {
            int colTovar = Util.random(1, 4);
            for (int i = 0; i < colTovar; i++) {
                int pos = Util.random(Tovar.tovar.size() - 1);
                System.out.print(this + "Положил в корзину товар ");
                Tovar.getPosition((HashMap) Tovar.tovar, pos);
                Util.sleep(Util.random(100, 200));
            }
            System.out.println(this + "Положил в корзину все товары");
        }
        else{
            int colTovar = Util.random(1, 4);
            for (int i = 0; i < colTovar; i++) {
                int pos = Util.random(Tovar.tovar.size() - 1);
                System.out.print(this + "(пенсионер) Положил в корзину товар ");
                Tovar.getPosition((HashMap) Tovar.tovar, pos);
                Util.sleep(Util.random(100, 200));
            }
            System.out.println(this + "(пенсионер) Положил в корзину все товары");
        }
    }
}
