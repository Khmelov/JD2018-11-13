package by.it._examples_.jd02_06.p11_mediator;

 class ConcreteColleague1 extends Colleague {

    ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("Colleague1 gets message: " + message);
    }
}
