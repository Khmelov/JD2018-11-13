package by.it.vchernetski.calcwithpatterns;

public abstract class Creator {
    public abstract Var factoryMethod(VarSelector varSelector, String op) throws CalcException;
}
