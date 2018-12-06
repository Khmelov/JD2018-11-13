package by.it.vchernetski.jd01_09;

abstract  class Var implements Operation, OpDispatch, OpObjects {
    public  String toString(){
        return "this Var";
    }
    public static Var createVar(String op){
        if (op.matches(Patterns.SCALAR)) return new Scalar(op);
        if (op.matches(Patterns.VECTOR)) return new Vector(op);
        if (op.matches(Patterns.MATRIX)) return new Matrix(op);
        return null;
    }
    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+"+"+other+" невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+"-"+other+" невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+"*"+other+" невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно");
        return null;
    }
}
