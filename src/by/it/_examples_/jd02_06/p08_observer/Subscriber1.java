package by.it._examples_.jd02_06.p08_observer;

class Subscriber1 implements Subscriber {
    @Override
    public void doAction(String message) {
        System.out.println(message + " from "
                + this.getClass().getSimpleName());
    }
}
