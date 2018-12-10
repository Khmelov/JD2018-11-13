package by.it.medvedeva.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("One");
        list.add("333333");
        System.out.println(list);
        list.remove(list);


    }
}
