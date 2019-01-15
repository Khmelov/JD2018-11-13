package by.it.vchernetski.calcwithpatterns;

interface OpDispatch {
    Var addDisp(Var other) throws CalcException;
    Var subDisp(Var other) throws CalcException;
    Var divDisp(Var other) throws CalcException;
    Var mulDisp(Var other) throws CalcException;
}
