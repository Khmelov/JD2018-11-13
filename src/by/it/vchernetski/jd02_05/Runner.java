package by.it.vchernetski.jd02_05;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OutPut outPut = new OutPut();
        outPut.Print();
        String task;
        while (!(task = sc.nextLine()).equals("exit")){
            switch (task){
                case "be":
                    outPut.changeLocale("be","BY");
                    outPut.Print();
                    break;
                case "ru":
                    outPut.changeLocale("ru","RU");
                    outPut.Print();
                    break;
                case "en":
                    outPut.changeLocale("en","EN");
                    outPut.Print();
                    break;
                default:
                    outPut.wrongCommand();
            }
        }
    }
}
