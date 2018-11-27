package by.it.denisova.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        masPeople();
    }

    private static void masPeople(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] people = new String[n];
        for (int i = 0; i < people.length; i++) {
            people[i] = scanner.next();
        }

        int [][] payCvart = new int[people.length][4];

        for (int i = 0; i <people.length ; i++) {
            System.out.println(" Введите зарплату для  " + people[i]);
            for (int j = 0; j <payCvart[i].length ; j++) {
                payCvart[i][j] = scanner.nextInt();
            }
        }
        printPeople(payCvart, people);

    }

    private static void printPeople(int[][] payCvart, String[] people){
        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");
        int sumAll=0;
        for (int i = 0; i < people.length; i++) {
            int sum = payCvart[i][0] + payCvart[i][1] + payCvart[i][2] + payCvart[i][3];
            sumAll = sumAll+sum;
            System.out.printf("%7s: %-9d %-9d %-9d %-9d %-5d\n", people[i],payCvart[i][0],payCvart[i][1],payCvart[i][2],payCvart[i][3], sum);
        }
        double avgAll = sumAll/people.length/4;
        System.out.println("------------------------------------------------------");
        System.out.printf("%-5d\n", sumAll);
        System.out.printf("%.4f",avgAll);
    }



}





