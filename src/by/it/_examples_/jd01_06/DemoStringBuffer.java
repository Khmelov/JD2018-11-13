package by.it._examples_.jd01_06;

import java.io.IOException;

public class DemoStringBuffer {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        System.out.println("длина —> " + sb.length());
        System.out.println("размер —>" + sb.capacity());
        sb.append("Java");
        System.out.println("строка —> " + sb);
        System.out.println("длина —> " + sb.length());
        System.out.println("размер —> " + sb.capacity());
        sb.append("Internationalization");
        System.out.println("строка —> " + sb);
        System.out.println("длина —> " + sb.length());
        System.out.println("размер —> " + sb.capacity());
        System.out.println("реверс —> " + sb.reverse());

    }

}








