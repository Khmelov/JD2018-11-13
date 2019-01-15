package by.it.baidak.calc;

public class ScalarCreator extends VarCreator {

    @Override
    public Var createVar(String operand) {
        return new Scalar(operand);
    }
}
