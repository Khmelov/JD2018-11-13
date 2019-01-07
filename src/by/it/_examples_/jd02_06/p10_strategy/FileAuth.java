package by.it._examples_.jd02_06.p10_strategy;

import java.io.File;

class FileAuth implements AuthStrategy{
    
    private File file;

    FileAuth(File file) {
        this.file = file;
    }
    

    @Override
    public boolean checkLogin(String name, String password) {
        System.out.println("Checking with file...");
        return checkFromFile();
    }
    
    private boolean checkFromFile(){
         // считывание из файла данных
        
        return true;
    }
 
}
