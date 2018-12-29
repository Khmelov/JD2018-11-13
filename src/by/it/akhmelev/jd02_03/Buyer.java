package by.it.akhmelev.jd02_03;

class Buyer extends Thread implements IBuyer {

    private boolean waiting = false;

    void stopWait(){
        synchronized (this) {
            waiting=false;
            this.notify();
        }
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to market.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "choosed goods.");
    }

    @Override
    public void goToQueue() {
        QueueBuyer.add(this);
        waiting = true;
        synchronized (this) {
            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "go out from market.");
        Dispatcher.removeBuyer();
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }
}
