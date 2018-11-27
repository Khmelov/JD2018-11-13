package by.it.skarpovich.jd01_01;

import java.util.Scanner;

public class Args {
    private String[] args;

    Args(String[] args) {
        this.args = args;
    }
    void printArgs() {
        int i = 1;
        for (String arg: args) {
            i=i+1;
            System.out.println("Аргумент " + i + "=" + arg);
        }
    }
}
