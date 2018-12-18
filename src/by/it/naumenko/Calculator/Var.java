package by.it.naumenko.Calculator;


abstract class Var implements Operation {
    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("сложение " + this + "+" + other + " невозможно");

    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption("вычетание " + this + "-" + other + " невозможно");
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("умножение " + this + "*" + other + " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("деление " + this + "/" + other + " невозможно");

    }

    static Var createVar(String operand) throws CalcExeption {
        if (operand.matches(Paterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Paterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Paterns.MATRIX))
            return new Matrix(operand);

        throw new CalcExeption("Неивестная переменная "+operand);
    }
}
