package by.it.baidak.calc;

public class VectorCreator extends VarCreator {

    @Override
    public Var createVar(String operand) {
        return new Vector(operand);
    }
}
