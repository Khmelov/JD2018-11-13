package by.it.zakharenko.jd01_07;

public class Scalar extends Var {

        private double value;

        Scalar(double value) {
            this.value = value;
        }
        Scalar(String strValue){
            value = Double.parseDouble(strValue);
        }
        Scalar(Scalar otherScalar){
            this.value = otherScalar.value;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
}