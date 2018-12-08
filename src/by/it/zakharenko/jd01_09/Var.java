package by.it.zakharenko.jd01_09;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+"+"+other+" невозможно!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+"-"+other+" невозможно!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+"*"+other+" невозможно!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно!");
        return null;
    }

    @Override
    public String toString() {
        return "this Var";
    }


    static Var createVar(String operand) {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        return null;
    }
}
