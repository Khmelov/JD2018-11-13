package by.it.seroglazov.calc;

public interface ScalarOperations {
    Var add(Scalar s) throws CalcException;
    Var sub(Scalar s) throws CalcException;
    Var mul(Scalar s) throws CalcException;
    Var div(Scalar s) throws CalcException;
}
