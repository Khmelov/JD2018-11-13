package by.it.seroglazov.calc;

public interface MatrixOperations {
    Var add(Matrix m) throws CalcException;
    Var sub(Matrix m) throws CalcException;
    Var mul(Matrix m) throws CalcException;
    Var div(Matrix m) throws CalcException;
}
