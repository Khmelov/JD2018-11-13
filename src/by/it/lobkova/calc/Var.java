package by.it.lobkova.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static void setVar(String key, Var value) {
        vars.put(key, value);
    }

    static Var createVar(String operand) throws ExceptionCalc {
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        return vars.get(operand);
    }

    @Override
    public Var add(Var other) throws ExceptionCalc {
        throw new  ExceptionCalc("Сложение " + this + " и " + other + " невозможно");
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " + " + other + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " + " + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) throws ExceptionCalc {
        System.out.println("Деление " + this + " + " + other + " невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "this Var";
    }

}


