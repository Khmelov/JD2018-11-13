package by.it.seroglazov.jd01_12;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        LinkedList<Character> chList = new LinkedList<>();
        boolean correct = true;
        for (char ch : chars) {
            if (!correct) break;
            Character cOb;
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    chList.addFirst(ch);
                    break;
                case ')':
                    cOb = chList.pollFirst();
                    if (cOb == null || !cOb.equals('(')){
                        correct = false;
                    }
                    break;
                case '}':
                    cOb = chList.pollFirst();
                    if (cOb == null || !cOb.equals('{')){
                        correct = false;
                    }
                    break;
                case ']':
                    cOb = chList.pollFirst();
                    if (cOb == null || !cOb.equals('[')){
                        correct = false;
                    }
                    break;
            }
        }
        if (chList.size() > 0) correct = false;
        System.out.println(correct);
    }
}
