package by.it.evenchik.jd01_07;

class Vector extends Var{


    double[]mas;

    public Vector(double[]vel) {
        this.mas=vel;
    }
    public  Vector(Vector vector){
        this.mas = vector.mas;
    }

    public  Vector(String strVector){
        char lastChar = strVector.charAt(strVector.length() - 1);
String modSt = strVector.substring(1,lastChar);
        System.out.println("modSt-------"+modSt);
       String [] arrStr = strVector.split(",");
       double[] msd = new double [arrStr.length];
        for (int i = 1; i < arrStr.length-1; i++) {
            System.out.println("i-----"+arrStr[i]);
            msd[i] = Double.parseDouble(arrStr[i]);

        }
        this.mas = msd;

    }

    @Override
    public  String toString () {
        StringBuilder sb = new StringBuilder("{");
        String delimiter ="";
        for (double element : mas) {
            System.out.println("---------------element"+element);
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
