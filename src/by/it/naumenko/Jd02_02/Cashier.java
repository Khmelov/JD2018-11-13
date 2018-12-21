package by.it.naumenko.Jd02_02;

import java.util.Date;

public class Cashier implements Runnable {

    String name;
    static Date date = new Date();

    @Override
    public void run() {

        System.out.println(this+"Открыл кассу");
        while (!Dispecher.shopCloosed()){
            Util.sleep(1000);
            Buyer buyerExtract = QueeBuyer.buyerExtract();
            if(buyerExtract==null)
                Util.sleep(1);
            else{
                System.out.println("---"+this+"Начал обслуживать "+ buyerExtract);
                Util.sleep(Util.random(2000,5000));
                System.out.println("---"+this+"Закончил обслуживать "+buyerExtract);
                System.out.println("Общая сумма чека "+this+Buyer.chekKassa());

                synchronized (buyerExtract) {
                    buyerExtract.notify();
                }
            }
        }
        System.out.println(this+"Закрыл кассу");
    }

    public Cashier(int number) {
        this.name = "Кассир " + number + ": ";
    }

    @Override
    public String toString() {
        return name;
    }
}
