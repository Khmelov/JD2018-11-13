package by.it.kovalyova.jd02_01;

class Buyer extends Thread implements IBuyer {
    Buyer(int number){
        super("Buyer № + number");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to market.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Util.random(500,2000);
        Util.sleep(timeout);
        System.out.println(this + "choosed goods.");
    }

    @Override
    public void goOut() {
        System.out.println(this + "go out from market.");
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }
}
