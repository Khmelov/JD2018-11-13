package by.it.kruglenja.jd01_08;

/**
 * Created by user on 27.11.2018.
 */
abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + "невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + "невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + "невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / " + other + "невозможна");
        return null;
    }

    public abstract String toString();

}
