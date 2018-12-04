package by.it.malishevskiy.jd01_08;

abstract class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + other + " невозможна");
            return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция делентия " + this + other + " невозможна");
        return null;
    }//Создание абстрактного класса. Нужен для предоставления базового функционала для наследников
    public abstract String toString();
    }
