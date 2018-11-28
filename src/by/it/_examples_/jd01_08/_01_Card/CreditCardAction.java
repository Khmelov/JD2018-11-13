package by.it._examples_.jd01_08._01_Card;

public class CreditCardAction extends CardAction {
    // поля, конструкторы, методы
    public boolean checkCreditLimit() { // собственный метод
        return true; // stub
    }
    @Override // аннотация указывает на полиморфную природу метода (для IDE)
    public void doPayment(double amountPayment) { // переопределенный метод
    // реализация
        System.out.println("complete from credit card");
    }
}

