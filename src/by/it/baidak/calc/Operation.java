package by.it.baidak.calc;

public interface Operation {
    Var add(Var v);
    Var sub(Var v);
    Var mul(Var v);
    Var div(Var v) throws CalcException;

}
