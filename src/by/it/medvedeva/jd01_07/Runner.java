package by.it.medvedeva.jd01_07;

public class Runner {


    public Runner() {
    }

    public static void main(String[] args) {
        Var v1= new Scalar(3.14);
        double [] t={1.0,2.0,4.0};
        Var v2= new Vector(t);
        System.out.println(v1);
        System.out.println(v2);


    }
}
