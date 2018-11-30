package by.it.lobkova.jd01_08;

 abstract class Var  implements Operation{

    private Object value;

    public Var(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

     @Override
     public Var add(Var other) {
         System.out.println("");
         return null;
     }

     @Override
     public Var sub(Var other) {
         System.out.println("");
         return null;
     }

     @Override
     public Var mul(Var other) {
         System.out.println("");
         return null;
     }

     @Override
     public Var div(Var other) {
         System.out.println("");
         return null;
     }
 }
