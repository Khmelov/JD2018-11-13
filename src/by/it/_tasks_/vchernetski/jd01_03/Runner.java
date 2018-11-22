package by.it._tasks_.vchernetski.jd01_03;

import by.it.vchernetski.jd01_03.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) throws IOException {
//        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
//        BufferedReader reader=new BufferedReader(inputStreamReader);
//        String line=reader.readLine();
//        double [] mas=InOut.getArray(line);
//        InOut.printArray(mas);
//        System.out.println();
//        Helper.sort(mas);
//        InOut.printArray(mas);
        double[][] m = {{1,2,3},{4,5,6}};
        double[][] v = {{1,2},{3,4},{5,6}};
        double[][] f= Helper.mul(m,v);
        System.out.println(m.length + " "+v[0].length);
        for (int i = 0; i <f.length ; i++) {
            for (int j = 0; j <f[i].length; j++) {
                System.out.print(f[i][j]+" ");
            }
            System.out.println();
        }
    }
}
