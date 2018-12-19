package by.it.vchernetski.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] ar = new int[6][4];
        for (int i = 0; i < ar.length; i++) {
            for (int i1 = 0; i1 < ar[i].length; i1++) {
                ar[i][i1]=-15+(int)(Math.random()*31);
            }
        }
        try(PrintWriter out=new PrintWriter(new FileWriter(Util.getPath("matrix.txt")))){
            for (int i = 0; i < ar.length; i++) {
                for (int i1 = 0; i1 < ar[i].length; i1++) {
                    out.printf("%3d ", ar[i][i1]);
                }
                out.println();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try(BufferedReader in = new BufferedReader(new FileReader(Util.getPath("matrix.txt")))){
            while(in.ready()){
                System.out.println(in.readLine());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
