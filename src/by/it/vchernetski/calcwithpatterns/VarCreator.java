package by.it.vchernetski.calcwithpatterns;

import by.it.vchernetski.calc.errors.Errors;

import static by.it.vchernetski.calcwithpatterns.Var.resMan;
import static by.it.vchernetski.calcwithpatterns.Var.vars;

public class VarCreator extends Creator {


    @Override
    public Var factoryMethod(VarSelector varSelector, String op) throws CalcException {
        switch (varSelector) {
            case MATRIX:
                return new Matrix(op);
            case SCALAR:
                return new Scalar(op);
            case VECTOR:
                return new Vector(op);
            case VAR:
                return vars.get(op);
        }
        throw null;
    }
}
