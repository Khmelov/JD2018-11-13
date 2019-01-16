package by.it.vchernetski.calcwithpatterns;

import by.it.vchernetski.calcwithpatterns.errors.Errors;

import static by.it.vchernetski.calcwithpatterns.Var.resMan;
import static by.it.vchernetski.calcwithpatterns.Var.vars;

enum VarSelector {
    VAR, SCALAR,VECTOR,MATRIX;
    protected static VarSelector getVarType(String text) throws CalcException{
        if (text.matches(Patterns.SCALAR)) return SCALAR;
        if (text.matches(Patterns.VECTOR)) return VECTOR;
        if (text.matches(Patterns.MATRIX)) return MATRIX;
        else if (vars.containsKey((text))) return VAR;
        else throw new CalcException(resMan.get(Errors.ERR_CR)+" "+text);
    }
}
