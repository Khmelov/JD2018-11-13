package by.it.mnovikov.jd01_01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String si = br.readLine();
//        int i = Integer.parseInt(si);

//        System.out.println(i);
        Hello hello = new Hello();
        System.out.println(hello.getSlogan());
        hello.setSlogan("Привет мир!!");
        System.out.println(hello.getSlogan());
        // write your code here
    }
}
