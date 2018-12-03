package by.it._examples_.jd01_09.inner;


public class ParentClass {
    // поля и конструкторы
    private SubClass eng;
    // abstract, final, private, protected - допустимы
    class SubClass { // определение внутреннего (inner) класса
        // тут поля и методы
        void launch() {
            System.out.println("SubClass работает");
        }
    } // конец объявления внутреннего класса

    public final void init() { // метод внешнего класса ParentClass
        System.out.println("init ParentClass");
        eng = new SubClass();
        eng.launch();
    }
}