package by.it._examples_.jd02_06.p06_adapter.objects;

import by.it._examples_.jd02_06.p06_adapter.adapter.PrinterAdapter;

import java.util.ArrayList;

// клиент, который хотел бы уметь печатать сразу много текста
// работает с адаптером, а не с принтером напрямую
public class Client {
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("text1");
        list.add("text2");
        list.add("text3");
                
        
        PrinterAdapter printerAdapter = new PrinterAdapter();
        printerAdapter.print(list);
    }

}
