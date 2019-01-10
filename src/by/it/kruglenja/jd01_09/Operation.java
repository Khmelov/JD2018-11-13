package by.it.kruglenja.jd01_09;

public interface Operation {
    Var add(Var other) throws CalcExceptions;;
    Var sub(Var other)throws CalcExceptions;;
    Var mul(Var other)throws CalcExceptions;;
    Var div(Var other)throws CalcExceptions;;
}
