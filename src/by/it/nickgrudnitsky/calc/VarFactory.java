package by.it.nickgrudnitsky.calc;

class VarFactory {
    Var createVar(String type, String operand) {
        Var var = null;
        switch (type) {
            case "SCALAR":
                var = new Scalar(operand);
        }
        switch (type) {
            case "VECTOR":
                var = new Vector(operand);
        }
        switch (type) {
            case "MATRIX":
                var = new Matrix(operand);
        }
        return var;
    }
}
