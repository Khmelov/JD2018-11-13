package by.it._examples_.jd02_06.p08_observer;
import java.util.ArrayList;

interface PublisherInterface {
    ArrayList<Subscriber> getListeners();
    void addListener(Subscriber listener);
    void removeListener(Subscriber listener);
    void removeAllListeners();
    void notifySubscribers(String message);
}
