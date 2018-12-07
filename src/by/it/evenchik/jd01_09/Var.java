package by.it.evenchik.jd01_09;

public abstract class  Var implements Operation {


    static Var createVar (String operand){
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALSR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        return null;


    }



    @Override
    public Var add(Var other) {
        System.out.println("операция сложения "+this+"+"+ other+"невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("операция вычитания "+this+"-"+ other+"невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("операция умножения"+this+"*"+ other+"невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("операция диления"+this+"/"+ other+"неаозможна");
        return null;
    }
}
