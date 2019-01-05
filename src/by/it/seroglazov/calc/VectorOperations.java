package by.it.seroglazov.calc;

public interface VectorOperations {
    Var add(Vector v) throws CalcException;
    Var sub(Vector v) throws CalcException;
    Var mul(Vector v) throws CalcException;
    Var div(Vector v) throws CalcException;
}
