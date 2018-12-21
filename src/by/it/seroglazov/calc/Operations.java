package by.it.seroglazov.calc;

public interface Operations {
    Var add(Var other) throws CalcExeption;
    Var sub(Var other) throws CalcExeption;
    Var mul(Var other) throws CalcExeption;
    Var div(Var other) throws CalcExeption;
}
