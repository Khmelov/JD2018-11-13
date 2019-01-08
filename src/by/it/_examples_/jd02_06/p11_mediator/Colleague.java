package by.it._examples_.jd02_06.p11_mediator;

abstract class Colleague {

    private Mediator mediator;

    Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    void send(String message) {
        mediator.send(message, this);
    }

    public abstract void notify(String message);
}
