package by.it.malishevskiy.jd01_08;

import by.it._examples_.jd01_07.matrixOk.Matrix;
import by.it._examples_.jd01_07.matrixOk.MatrixException;

public class Runner {
    static void print (Var var) {System.out.println(var);}

        public static void main (String[]args) throws MatrixException {
            Var s = new Scalar(3.0);
            Var v = new Vector(new double[]{1,2,3});
 //         Var m = new Matrix("{1,2,3},{4,5,6},{7,8,9}");
            //Калькулятор для Скаляров
            print(s.add(s));
            print(s.sub(s));
            print(s.mul(s));
            print(s.div(s));
            //Калькулятор для Векторов
            print(v.add(v));
            print(v.sub(v));
            print(v.mul(v));
            print(v.div(v));
/*          Калькулятор для Матрицы
            print(m.add(m));
            print(m.sub(m));
            print(m.mul(m));
            print(m.div(m)); */
        }
    }
