package by.it.naumenko.jd03_02;

import by.it.naumenko.jd03_01.C_Init;
import by.it.naumenko.jd03_01.C_Reset;

public class ResetDB {
    public static void main(String[] args) {

        C_Reset resetDB = new C_Reset();
        resetDB.reset();
        C_Init createDB = new C_Init();
        createDB.create();
        System.out.println("База данныых сбросилась");


    }
}
