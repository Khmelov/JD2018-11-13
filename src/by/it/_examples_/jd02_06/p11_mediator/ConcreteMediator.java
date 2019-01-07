package by.it._examples_.jd02_06.p11_mediator;

class ConcreteMediator extends Mediator {

    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    void setColleague1(ConcreteColleague1 colleague) {
        this.colleague1 = colleague;
    }

    void setColleague2(ConcreteColleague2 colleague) {
        this.colleague2 = colleague;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague.equals(colleague2)) {
            colleague1.notify(message);
        } else {
            colleague2.notify(message);
        }
    }
}
