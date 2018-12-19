package by.it.seroglazov.calc;

public interface OperationsDispatch {
    Var addDispatch(Var other) throws CalcExeption;

    Var subDispatch(Var other) throws CalcExeption;

    Var mulDispatch(Var other) throws CalcExeption;

    Var divDispatch(Var other) throws CalcExeption;
}
