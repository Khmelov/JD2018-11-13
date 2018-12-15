package by.it.malishevskiy.calc;

abstract class Var implements Operation {

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCAKAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Scalar(operand);
        }
        return null;
    }

        @Override
        public Var add (Var other){
            System.out.println("Операция сложения " + this + other + " невозможна");
            return null;
        }

        @Override
        public Var sub (Var other){
            System.out.println("Операция вычитания " + this + other + " невозможна");
            return null;
        }

        @Override
        public Var mul (Var other){
            System.out.println("Операция умножения " + this + other + " невозможна");
            return null;
        }

        @Override
        public Var div (Var other){
            System.out.println("Операция делентия " + this + other + " невозможна");
            return null;
        }//Создание абстрактного класса. Нужен для предоставления базового функционала для наследников
        public abstract String toString ();

}