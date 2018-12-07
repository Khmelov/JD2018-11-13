package by.it.vchernetski.jd01_09;

public interface OpObjects {
    Var add (Scalar other);
    Var sub (Scalar other);
    Var mul (Scalar other);
    Var div (Scalar other);
    Var add (Matrix other);
    Var sub (Matrix other);
    Var mul (Matrix other);
    Var div (Matrix other);
    Var add (Vector other);
    Var sub (Vector other);
    Var mul (Vector other);
    Var div (Vector other);
}
