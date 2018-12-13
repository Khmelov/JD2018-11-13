package by.it.vchernetski.calc;

interface OpDispatch {
    Var addDisp (Var other) throws CalcException;
    Var subDisp (Var other) throws CalcException;
    Var divDisp (Var other) throws CalcException;
    Var mulDisp (Var other) throws CalcException;
}
