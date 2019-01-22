package by.it.lobkova.calc;

enum VarMaker {
    SCALAR {
        @Override
        Var create(String str) throws CalcException {
            return new Scalar(str);
        }
    },
    VECTOR {
        @Override
        Var create(String str) throws CalcException {
            return new Vector(str);
        }
    },
    MATRIX {
        @Override
        Var create(String str) throws CalcException {
            return new Matrix(str);
        }
    };

    abstract Var create(String str) throws CalcException;
}
