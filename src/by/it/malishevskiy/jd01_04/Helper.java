package by.it.malishevskiy.jd01_04;


public class Helper {

   public static void sort(double[] a){
        for(int last = a.length - 1; last > 1; last--) {
            for (int i = 0; i < last; i++) {
                if (a[i] > a[i + 1]) {
                    double buf = a[i];
                    a[i] = a[i +1];
                    a[i + 1] = buf;
                }
            }
        }
    }
  }