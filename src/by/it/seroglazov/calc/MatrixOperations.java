package by.it.seroglazov.calc;

public interface MatrixOperations {
    Var add(Matrix m) throws CalcExeption;

    Var sub(Matrix m) throws CalcExeption;

    Var mul(Matrix m) throws CalcExeption;

    Var div(Matrix m) throws CalcExeption;
}
