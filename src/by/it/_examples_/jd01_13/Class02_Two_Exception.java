package by.it._examples_.jd01_13;

public class Class02_Two_Exception {
        public void doAction() {
            try {
                int a = (int)(Math.random() * 4);
                System.out.println("a = " + a);
                int c[] = { 1/a, a};  // первая возможная ошибка (деление на 0)
                c[a] = 71;            // вторая возможная ошибка (массив в два элемента)
            } catch(ArithmeticException e) {
                System.err.println("деление на 0: " + e);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.err.println("out of bound: " + e);
            } // окончание try-catch блока
            System.out.println("after try-catch");
        }

    public static void main(String[ ] args) {
        Class02_Two_Exception cl=new Class02_Two_Exception();
        cl.doAction();
    }

}
