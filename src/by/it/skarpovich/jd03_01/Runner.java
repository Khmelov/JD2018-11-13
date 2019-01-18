package by.it.skarpovich.jd03_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    public static void main(String[] args) {
        C_Init.createDatabase();
        System.out.println("DataBase has been created and filled!");
        System.out.println("...");
        System.out.println("Do you want to delete tables and DataBase now? (y/n)");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String question=bf.readLine();
            if (question.equalsIgnoreCase("y")){
                C_Reset.deleteTables();
                System.out.println("DataBase has been deleted... :(");
            } else {
                System.out.println("DataBase left. Thank you! :)");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        C_Reset.deleteTables();

    }
}
