package by.it._examples_.jd01_13;

public class Class06_Throw_example {


        //nested класс - источник исключения
        public static class Connector {
            public static void loadResource(SameResource f) {
                if (f == null || !f.exists() || !f.isCreate()) {
                    throw new IllegalArgumentException(); /* генерация исключения */
                // тут можно и свое, например, throw new IllegalResourceException();
                }
            // некий функционал
            }
        }

        //базовый метод - обработчик исключения
        public static void main(String[ ] args) {
            SameResource f = new SameResource(); // SameResource f = null;
            try {// необязателен только при гарантированной корректности значения параметра
                Connector.loadResource(f);
            } catch(IllegalArgumentException e) {
                System.err.print("обработка unchecked-исключения вне метода: " + e);
            }
        }



        public static class SameResource {
                // поля, конструкторы
            public boolean isCreate() {
                // некий функционал
                return false;
            }
            public boolean exists() {
                // некий функционал
                return false;
            }
            public void execute() {
                // некий функционал
            }
            public void close() {
                // некий функционал
            }
        }
}
