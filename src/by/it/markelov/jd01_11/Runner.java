package by.it.markelov.jd01_11;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();

////////////A////////////////////////////
        list.add("один");
        list.add("два");
        list.add("три");
      System.out.println(list);

/*   String remove = list.remove(1);
        System.out.println(list);
        System.out.println(remove);*/
/////////////B///////////////////////////
        String repl = list.set(1, "жара");
        System.out.println(repl);
        System.out.println(list);

        list.add(1, "холод");
        System.out.println(list);

        ArrayList<String> list2=new ArrayList<>();
        list2.add("пять");
        list2.add("шесть");
        list2.add("семь");

        list.addAll(list2);
        System.out.println(list);


        System.out.println("\n");




        ListA<String> myList=new ListA<> ();
/////////////A//////////////////////////
        myList.add("один");
        myList.add("два");
        myList.add("три");
      System.out.println(myList);

 /*       String remove1 = myList.remove(1);
        System.out.println(myList);
        System.out.println(remove1);*/
//////////////B/////////////////////////////
        ListB<String> myListB=new ListB<> ();
        myListB.add("один");
        myListB.add("два");
        myListB.add("три");
        String repl1 = myListB.set(1, "жара");
        System.out.println(repl1);
        System.out.println(myListB);

//
         myListB.add(1, "холод");
         System.out.println(myListB);




        ListB<String> myListB2=new ListB<> ();
        myListB2.add("пять");
        myListB2.add("шесть");
        myListB2.add("семь");
        System.out.println(myListB2);

//        myListB.addAll(myListB2);
//        System.out.println(myListB);



        }


    }

