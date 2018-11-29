package by.it._examples_.jd01_08;

public class Demo {
    class ConstMethod {
      // метод method() не может быть полиморфным
      final void method() {}
    }
    class Sub extends ConstMethod {
     // следующий метод невозможен
     //   @Override
     //   void method() {} // ошибка компиляции
    }

    // класс String не может быть суперклассом
    //    public final class String { /* код */ }
    //    // следующий класс невозможен
    //    class MegaString extends String { /* код */ } // ошибка компиляции


    public class WrapperString {
        private String str;
        public WrapperString() {
            str = new String();
        }
        public WrapperString(String s) {
            str = new String(s);
        }
        public int indexOf(int arg) { // делегированный метод
        // новая функциональность
            return arg;
        }
        // другие делегированные методы
    }

}
