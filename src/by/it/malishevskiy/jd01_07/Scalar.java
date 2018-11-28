package by.it.malishevskiy.jd01_07;

     class Scalar extends AbstractVar {

         private double value;

         Scalar(double value) {
             this.value = value;
         }

         Scalar(String strvalue){
             this.value = Double.parseDouble(strvalue);
         }

         Scalar(Scalar newScalar){
             this.value = newScalar.value;
         }

         public String toString() {
             return String.valueOf(value);
         }
     }
