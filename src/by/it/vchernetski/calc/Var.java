package by.it.vchernetski.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract  class Var implements Operation, OpDispatch, OpObjects {
    private static Map<String, Var> vars = new HashMap<>();
    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }

    public static void printvar() {
        for(Map.Entry<String, Var> var: vars.entrySet()){
            System.out.println(var.getKey()+"="+var.getValue());
        }
    }

    public static void sortvar() {
        Map<String, Var> tvar = new TreeMap<>(vars);
        for(Map.Entry<String, Var> var: vars.entrySet()){
            System.out.println(var.getKey()+"="+var.getValue());
        }
    }

    public  String toString(){
        return "this Var";
    }
    public static Var createVar(String op){
        if (op.matches(Patterns.SCALAR)) return new Scalar(op);
        if (op.matches(Patterns.VECTOR)) return new Vector(op);
        if (op.matches(Patterns.MATRIX)) return new Matrix(op);
        else if (vars.containsKey((op))) return vars.get(op);
        return null;
    }
    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+"+"+other+" невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+"-"+other+" невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+"*"+other+" невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно");
        return null;
    }
}
