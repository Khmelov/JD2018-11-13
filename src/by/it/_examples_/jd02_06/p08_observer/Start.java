package by.it._examples_.jd02_06.p08_observer;

public class Start {

    public static void main(String[] args) {
        Subscriber subscriber1 = new Subscriber1();
        Subscriber subscriber2 = new Subscriber2();
        Publisher publisher = new Publisher();
        publisher.addListener(subscriber1);
        publisher.addListener(subscriber2);
        publisher.createNewMessage("Message!");
    }
}
