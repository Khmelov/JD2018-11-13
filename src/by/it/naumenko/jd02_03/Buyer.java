package by.it.naumenko.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacked {

    //public  Map<String,Double>[] check = new HashMap<String,Double>[];
   public List<Map<String,Double>> chek = new ArrayList<>();
    public static boolean pensioneer;
    private boolean wating = false;

    void stopWait(){
        synchronized (this) {
            wating=false;
            this.notify();
        }
    }
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
        Dispecher.removeBuyer();
    }

    @Override
    public void goToQuee() {
        QueeBuyer.addBuyerQuee(this);
        wating = true;
        System.out.println(this+"стал в очередь");
        synchronized (this){
            while (wating){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        enterToMArket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQuee();
        goOut();
    }

    @Override
    public String toString() {
        return super.getName();
    }

    Buyer(int number) {

        super("Покупатель № " + number + " ");
        pensioneer=Math.random()<0.25;
        Dispecher.addBuyer();
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

//            check[Dispecher.buyerCounter]=new HashMap<>();
            for (int i = 0; i < colTovar; i++) {
                int pos = Util.random(Tovar.tovar.size() - 1);
                System.out.print(this + "Положил в корзину товар ");
                Tovar.getPosition((HashMap) Tovar.tovar, pos);
                //check[2].put(Tovar.getKeyMap((HashMap) Tovar.tovar,pos),Tovar.getValueMap((HashMap) Tovar.tovar,pos));
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

    public static double chekKassa(){
        return Tovar.summaChek((HashMap<String, Double>) Tovar.tovar);
    }
}



