package by.it.vchernetski.calcwithpatterns;

public interface OpObjects {
    Var add(Scalar other) throws CalcException;
    Var sub(Scalar other) throws CalcException;
    Var mul(Scalar other)throws CalcException;
    Var div(Scalar other)throws CalcException;
    Var add(Matrix other)throws CalcException;
    Var sub(Matrix other)throws CalcException;
    Var mul(Matrix other)throws CalcException;
    Var div(Matrix other)throws CalcException;
    Var add(Vector other)throws CalcException;
    Var sub(Vector other)throws CalcException;
    Var mul(Vector other)throws CalcException;
    Var div(Vector other)throws CalcException;
}
