package by.it._examples_.jd01_09.nested;

class ParentForNested {
    private int id;

    // abstract, final, private, protected - допустимы
    static class SubClassNested {
        private int boatId;

        static void downAll() {
            System.out.println("Всем стоп");
        }

        void goOne() {
            System.out.println("Один пошел");
        }
    }
}