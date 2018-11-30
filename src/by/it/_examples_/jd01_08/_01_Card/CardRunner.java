package by.it._examples_.jd01_08._01_Card;

public class CardRunner {
    public static void main(String[ ] args) {
        CardAction dc1 = new CardAction();
        CardAction dc2 = new CreditCardAction();
        CreditCardAction cc = new CreditCardAction();
        // CreditCardAction cca = new CardAction(); // ошибка компиляции
        dc1.doPayment(15.5); // метод класса CardAction
        dc2.doPayment(21.2); // полиморфный метод класса CreditCardAction
        cc.doPayment(7.0); // полиморфный метод класса CreditCardAction
        cc.checkCreditLimit(); // неполиморфный метод класса CreditCardAction
        // dc2.checkCreditLimit(); // ошибка компиляции – неполиморфный метод
        ((CreditCardAction)dc1).checkCreditLimit(); // ошибка времени выполнения
        ((CreditCardAction)dc2).checkCreditLimit(); // ок
    }
}







