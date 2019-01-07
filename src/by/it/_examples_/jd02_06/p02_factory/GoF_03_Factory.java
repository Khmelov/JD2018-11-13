package by.it._examples_.jd02_06.p02_factory;

public class GoF_03_Factory {
    public static void main(String[] args) {
        // an array of creators
        Creator[] creators = {new CreatorVar(), new CreatorVec()};
        // iterate over creators and create products
        for (Creator creator : creators) {
            Var product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
    }
}

class Var { }

class VarScalar extends Var { }

class VarVector extends Var { }

abstract class Creator {
    public abstract Var factoryMethod();
}

class CreatorVar extends Creator {
    @Override
    public Var factoryMethod() { return new VarScalar(); }
}

class CreatorVec extends Creator {
    @Override
    public Var factoryMethod() { return new VarVector(); }
}

