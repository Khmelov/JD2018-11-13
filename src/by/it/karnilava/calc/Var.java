package by.it.karnilava.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();
    static SortedMap<String, Var> sortedVars = new TreeMap<>();



    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        sortedVars.put(name,var);
        return var;
    }



    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + "+" + this + other + " невозможна");

    }

    @Override
    public Var sub(Var other)throws CalcException  {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");

    }

    @Override
    public Var mul(Var other)throws CalcException  {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");

}

    @Override
    public Var div(Var other)throws CalcException  {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");

    }

// Определение типа переменной из строки

    static Var createVar(String operand) throws CalcException{
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);

        throw  new CalcException("Невозможно создать "+operand);

    }


}

