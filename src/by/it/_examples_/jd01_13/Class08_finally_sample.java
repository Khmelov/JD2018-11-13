package by.it._examples_.jd01_13;

public class Class08_finally_sample {

        public static class SameResource{
            void execute() {/* что-то делается */};
            void close()   {/* что-то делается */};
        };

        public void doAction() {
            SameResource sr = null;
            try {
                // реализация — захват ресурсов
                sr = new SameResource(); // возможна генерация исключения

                // реализация — использование ресурсов
                sr.execute(); // возможна генерация исключения
                // sr.close(); // освобождение ресурсов (некорректно)
            } finally {
                // освобождение ресурсов (корректно)
                if (sr != null) {
                    sr.close();
                }
            }
            System.out.print("after finally");
        }
}

