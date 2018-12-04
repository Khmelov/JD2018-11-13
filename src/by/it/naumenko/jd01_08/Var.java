package by.it.naumenko.jd01_08;


abstract class Var implements Operation {
    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("сложение " + this + "+" + other + " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("вычетание " + this + "-" + other + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("умножение " + this + "*" + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("деление " + this + "/" + other + " невозможно");
        return null;
    }
}
