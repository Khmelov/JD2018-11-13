package by.it._examples_.jd01_07;
@SuppressWarnings("all")
public class Department {
    {
        System.out.println("logic (1) id=" + this.id);
        // проверка и инициализация параметров конкретного объекта
        // СТАРТ: ДО КОНСТРУКТОРА КЛАССА
    }
    static {
        System.out.println("static logic");
        // проверка и инициализация базовых параметров, необходимых
        // для функционирования приложения (всего класса)
        // СТАРТ: ПРИ ПЕРВОМ ОБРАЩЕНИИ К ЛЮБОМУ МЕТОДУ КЛАССА.
    }
    private int id = 7;

    public Department(int id) {
        this.id = id;
        System.out.println("конструктор id=" + id);
    }
    public int getId() {
        return id;
    }

    { /* так можно, но весьма путает код при чтении */
        System.out.println("logic (2) id=" + id);
    }
}
