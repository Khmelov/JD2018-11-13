package by.it.seroglazov.calc;

public interface VectorOperations {
    Var add(Vector v) throws CalcExeption;

    Var sub(Vector v) throws CalcExeption;

    Var mul(Vector v) throws CalcExeption;

    Var div(Vector v) throws CalcExeption;
}
