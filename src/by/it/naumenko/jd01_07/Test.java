package by.it.naumenko.jd01_07;

public class Test {

    public static void main(String[] args) {
        String str = "{1.0,2.0,3.0,4.0}";
        str=str.replaceAll("[{}]","");
        String[] mas = str.split(",\\s*");
        double[] mas1 = new double[mas.length];
        //int k=0;
        for (int i = 0; i < mas.length; i++) {
            mas1[i] = Double.parseDouble(mas[i]);
            //if (i!=0) {

              //  k++;
            //}

//            if (mas[i].equals("")) {
//                mas1[k] = Double.parseDouble(mas[i]);
//                k++;
//            }

        }

        //double[] masiv = new double[mas.length];
        for (int i = 0; i < mas.length; i++) {
            //masiv[i] = Double.parseDouble(mas[i]);
            System.out.printf("mas[%d]=%s   ",i,mas[i]);
        }
        System.out.println("\n"+mas.length);

//        for (double v : mas1) {
//            System.out.print(v+"  ");
//        }
    }


}
