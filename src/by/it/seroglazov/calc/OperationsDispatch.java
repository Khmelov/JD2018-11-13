package by.it.seroglazov.calc;

public interface OperationsDispatch {
    Var addDispatch(Var other);

    Var subDispatch(Var other);

    Var mulDispatch(Var other);

    Var divDispatch(Var other);
}
