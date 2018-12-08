package by.it.burlakov.calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 27.11.2018.
 */
abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    public static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Map getVarsMap(){
        return vars;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " - " + other + " невозможно!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умнажение " + this + " * " + other + " невозможно!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " / " + other + " невозможно!");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");
        return null;
    }

    static Var createVar(String operand) {

        if(operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        } else if(operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        } else if(operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);
        } else if(vars.containsKey(operand)){
            return vars.get(operand);
        }

        return null;
    }
}
