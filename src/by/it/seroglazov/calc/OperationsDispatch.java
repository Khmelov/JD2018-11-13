package by.it.seroglazov.calc;

public interface OperationsDispatch {
    Var addDispatch(Var other) throws CalcException;
    Var subDispatch(Var other) throws CalcException;
    Var mulDispatch(Var other) throws CalcException;
    Var divDispatch(Var other) throws CalcException;
}
