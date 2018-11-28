package by.it._examples_.jd01_08._02_Dumb;

class Dumb {
    { this.id = 6; }
    int id;
    Dumb() {
        System.out.println("конструктор класса Dumb ");
        // вызов потенциально полиморфного метода - плохо
        id = this.getId();
        System.out.println(" id=" + id);
    }

    int getId() { // 1
        System.out.println("getId() класса Dumb ");
        return id;
    }
}


