package by.it.akhmelev.calc_v2;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();

    @Override
    public Var add(Var other)  throws CalcException {
        throw new CalcException("Сложение "+this+"+"+other+" невозможно!");
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        throw new CalcException("Вычитание "+this+"-"+other+" невозможно!");
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        throw new CalcException("Умножение "+this+"*"+other+" невозможно!");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление "+this+"/"+other+" невозможно!");
    }

    @Override
    public String toString() {
        return "this Var";
    }

    static void setVar(String key, Var value){
        vars.put(key, value);
    }

    static Var createVar(String operand) throws CalcException {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        Var var = vars.get(operand);
        if (var==null)
            throw  new CalcException("Неизвестная переменная: "+operand);
        return var;
    }
}
