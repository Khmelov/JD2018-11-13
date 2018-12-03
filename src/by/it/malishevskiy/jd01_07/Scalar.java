package by.it.malishevskiy.jd01_07;

     class Scalar extends Var {//Создание класса, наследуемого от абстрактного Var

         private double value;//Создание общей переменной.

         Scalar(double value) {//Говорим, что эта переменная равна добловой  value из Scalar
             this.value = value;
         }

         Scalar(String strvalue){
             this.value = Double.parseDouble(strvalue);//Говорим, что эта переменная равна стринговой strvalue
         }

         Scalar(Scalar newScalar){
             this.value = newScalar.value;
         }
         public String toString() {
             return String.valueOf(value);
         }
     }