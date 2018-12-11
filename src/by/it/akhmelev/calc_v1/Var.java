package by.it.akhmelev.calc_v1;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+"+"+other+" невозможно!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+"-"+other+" невозможно!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+"*"+other+" невозможно!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно!");
        return null;
    }

    @Override
    public String toString() {
        return "this Var";
    }

    static void setVar(String key, Var value){
        vars.put(key, value);
    }

    static Var createVar(String operand) {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        return vars.get(operand);
    }
}
