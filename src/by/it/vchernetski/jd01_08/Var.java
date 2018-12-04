package by.it.vchernetski.jd01_08;

import java.sql.SQLOutput;

abstract  class Var implements Operation{
    public  String toString(){
        return "this Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+"+"+other+" невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+"-"+other+" невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+"*"+other+" невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно");
        return null;
    }
}
