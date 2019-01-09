package by.it._examples_.jd02_06.p08_observer;

import java.util.ArrayList;

class Publisher implements PublisherInterface {
    private ArrayList<Subscriber> listeners = new ArrayList<>();
    @Override
    public ArrayList<Subscriber> getListeners() {
        return listeners;
    }
    @Override
    public void addListener(Subscriber listener) {
        listeners.add(listener);
    }
    @Override
    public void removeListener(Subscriber listener) {
        listeners.remove(listener);
    }
    @Override
    public void removeAllListeners() {
        listeners.clear();
    }
    @Override
    public void notifySubscribers(String message) {
        for (Subscriber actionListener : listeners) actionListener.doAction(message);
    }
    void createNewMessage(String message) {
        System.out.println("Publisher printed message " + message);
        notifySubscribers(message);
    }

}
