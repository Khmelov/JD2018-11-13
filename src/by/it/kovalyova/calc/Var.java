package by.it.kovalyova.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars=new HashMap<>();


    static Var createVar(String strVar){
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        //if (strVar.matches(Patterns.MATRIX))
        //    return new Matrix(operand);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        return null;
    }

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
        System.out.println("Умножние "+this+"*"+other+" невозможно!");

        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно!");

        return null;
    }

    @Override
    public String toString() {
        return "Это класс AbstractVar";
    }
}
