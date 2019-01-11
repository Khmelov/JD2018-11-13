package by.it._examples_.jd02_06.p06_adapter.adapter;

import by.it._examples_.jd02_06.p06_adapter.objects.Printer;

import java.util.List;

// адаптер, который совмещает желание клиента
// и возможности принтера
public class PrinterAdapter implements PageListPrinter{

    private Printer printer = new Printer();
    
    @Override
    public void print(List<String> list) {
        for (String text : list) {
            printer.print(text);            
        }
    }
 
}
