package by.it._examples_.jd01_08._07_Finalize;

public class Manager {
    private int id;
    public Manager(int value) {
        id = value;
    }
    protected void finalize() throws Throwable {
        try {
        // код освобождения ресурсов
            System.out.println("объект будет удален, id=" + id);
        } finally {
            super.finalize();
        }
    }
}
