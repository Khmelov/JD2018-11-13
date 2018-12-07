package by.it._examples_.jd01_11.Generics;

public class Demo {

    public static class Calc<T extends Number> {
        private String name;
        private T mark; // параметр поля
        public Calc(T mark, String name) { // параметр конструктора
            this.name = name;
            this.mark = mark;
            }
        public T getMark() { // параметр метода
            return mark;
            }
        private int roundMark() {
            return Math.round(mark.floatValue()); // метод класса Number
        }
        public boolean equalsToMark(Calc<?> ob) { // параметр метода
            return roundMark() == ob.roundMark();
        }
    }


    public static void main(String[ ] args) {
        Calc<Double> md1 = new Calc<Double>(71.41D,"Progr");// 71.5d
        Calc<Double> md2 = new Calc<Double>(71.45D, "Progr");// 71.5d
        System.out.println(md1.equalsToMark(md2));
        Calc<Integer> mi = new Calc<Integer>(71,"Progr");
        // md1.equalsToMark(mi); // ошибка компиляции: несовместимые типы
        }

/*
    //ошибка при применении конструктора
    class FailedOne <T> {
      // private T value = new T(); //тут невозможно определить тип.
    }


//  generic-поля не могут быть статическими, статические методы не могут
//  иметь generic-параметры или обращаться к generic-полям, например

    class FailedTwo <T1, T2> {
        static T1 value;
        T2 id;
        static T1 takeValue() {
            return value;
        }
        static void use() {
            System.out.print(id);
        }
    }
*/




   // <T extends Number> Integer methodName(T arg) { return null;}
   // <T> T[ ] methodName(int count, T arg) { arg. return T; }







}
