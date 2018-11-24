package by.it.burlakov.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        String[] persons = new String[count];

        for (int i = 0; i < persons.length; i++) {
            persons[i] = reader.readLine();
        }

        int[][] salary = new int[persons.length][];

        for (int i = 0; i < persons.length; i++) {
            System.out.println("Введите зарплату для " + persons[i]);
            String line = reader.readLine();
            salary[i] = getSplitArray(line);
        }

        printSalaryTable(persons, salary);
    }

     private static int[] getSplitArray(String line){
        String[] stringsArr = line.trim().split(" ");
        int[] result = new int[stringsArr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(stringsArr[i]);
        }
        return  result;
    }

     private static void printSalaryTable(String[]persons, int[][] salary){

        double sumAll = 0;

        for (int i = 0; i < persons.length; i++) {
            System.out.print(persons[i] + " ");
            for (int j = 0; j < salary[i].length; j++) {
                System.out.println(salary[i][j] + " ");
            }
            double sumPerson = getSumPersonSalary(salary[i]);
            sumAll += sumPerson;
        }
        System.out.println("Итого  " + sumAll);
        System.out.printf("Средняя %.4f  ", sumAll / (persons.length * 4));

    }

     private static int getSumPersonSalary(int []arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}