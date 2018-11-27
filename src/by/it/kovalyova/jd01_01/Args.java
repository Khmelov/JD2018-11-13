package by.it.kovalyova.jd01_01;

import java.sql.SQLOutput;

class Args {

private String[] args;

 Args(String[] args) {
    this.args=args;

}
void  printArgs () {
    int i = 1;
    for (String arg : args){
        i = i + 1;
        System.out.println("Аргумент " + i + "-" + arg);
    }
}
}
