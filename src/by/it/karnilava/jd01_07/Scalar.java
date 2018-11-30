package by.it.karnilava.jd01_07;

class Scalar extends AbstractVar {

    private double value;

     Scalar(double value) {
        this.value = value;
    }

    Scalar(String str){
         this.value = Double.parseDouble(str);

    }

    Scalar (Scalar scalar){
         this.value = scalar.value;

    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
