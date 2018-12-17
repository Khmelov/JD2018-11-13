package by.it.nickgrudnitsky.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (vars.containsKey(operand)) {
            return vars.get(operand);
        }
        return null; //todo Generate some Error
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + "невозможна.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + "невозможна.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + "невозможна.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / " + other + "невозможна.");
        return null;
    }

    @Override
    public String toString() {
        return "Это клаcc AbstractVar";
    }
}
