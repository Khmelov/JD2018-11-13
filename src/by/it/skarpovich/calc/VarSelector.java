package by.it.skarpovich.calc;

import by.it.skarpovich.calc.res.Messages;

class VarSelector {

    static Var createVar(String operand) throws CalcException {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        Var var = Var.vars.get(operand);
        if (var == null)
            throw new CalcException(ResMan.INSTANCE.get(Messages.STR_UNKNOWNVAR) + " " + operand);
        return var;
    }
}