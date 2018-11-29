package by.it.markelov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        String[] s = "{{1.0, 2.0}, {3.0, 4.0}}".split("}, ");

        for (String s1 : s) {
            //System.out.println(s1);

        }
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].replaceAll("[,}{]", "");}

        for (String s1 : s) {
                //System.out.println(s1);

            }


        String splitstrings1 []=new String[2];
        splitstrings1=s[0].split(" ");

        String splitstrings2 []=new String[2];
        splitstrings2=s[1].split(" ");

        double mas1[]=new double[splitstrings1.length];
        double mas2[]=new double[splitstrings2.length];

        for (int i = 0; i < splitstrings1.length; i++) {
            mas1[i]=Double.parseDouble(splitstrings1[i]);
            mas2[i]=Double.parseDouble(splitstrings2[i]);
        }
        for (double v : mas1) {
            System.out.print(v+" ");

        }
        System.out.println();

        for (double v : mas2) {
            System.out.print(v+" ");

        }



        }

    }


