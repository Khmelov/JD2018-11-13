package by.it.seroglazov.calc;

import java.util.HashMap;

public abstract class Var implements Operations, ScalarOperations, VectorOperations, MatrixOperations, OperationsDispatch {

    private static HashMap<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static String getVars() {
        StringBuilder sb = new StringBuilder();
        for (String varName : vars.keySet()) {
            sb.append(varName);
            sb.append('=');
            sb.append(vars.get(varName));
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "this abstract class";
    }

    @Override
    public Var add(Var other) throws CalcException {
        writeLogAndThrowException(ResMan.get("addition") + " " + this + " + " + other + " " + ResMan.get("impossible"));
        return null;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        writeLogAndThrowException(ResMan.get("subtraction") + " " + this + " - " + other + " " + ResMan.get("impossible"));
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        writeLogAndThrowException(ResMan.get("multiple") + " "+ this + " * " + other + " " + ResMan.get("impossible"));
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        writeLogAndThrowException(ResMan.get("division") + " " + this + " / " + other + " " + ResMan.get("impossible"));
        return null;
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return VarCreator.SCALAR.create(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return VarCreator.VECTOR.create(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return VarCreator.MATRIX.create(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);
        writeLogAndThrowException(ResMan.get("impossibleToCreate")+" " + strVar);
        return null;
    }

    static void writeLogAndThrowException(String text) throws CalcException {
        Logger.getInstance().add("ERROR: " + text);
        throw new CalcException(text);
    }

}
