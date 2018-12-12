package by.it._examples_.jd01_12;

import java.util.*;


public class CollectionsSpeed {
    private static void prn(Object o){System.out.println(o.toString());}
    public static void main(String[ ] args) {
        //опорный обычный массив для экспериментов
        //ВАЖНО. не int[] а именно Integer[], иначе не добавится
        Integer[] intArray={1,3,1,2,5,3,4,2,0,0,0,2,4,5,7,9,7,6,5};
        List<Integer> base= Arrays.asList(intArray); //опорная коллекция

        //ArrayList
        Timer t=new Timer();
        List<Integer> arrayList=new ArrayList<>(base);
        prn("\nКопирование коллекции в arrayList. "+t);
        prn(arrayList);
        //LinkedList
        LinkedList<Integer> linkedList=new LinkedList<>(base);
        prn("Копирование коллекции в linkedList. "+t);
        prn(linkedList);
        //hashSet
        Set<Integer> hashSet=new HashSet<>(base);
        prn("Копирование коллекции в HashSet. " + t);
        prn(hashSet);
        //hashSet
        Set<Integer> treeSet=new TreeSet<>(base);
        prn("Копирование коллекции в TreeSet. "+t);
        prn(treeSet);


        //добавление
        for (int i = 0; i < 10000; i++) {arrayList.add(5,i);}
        prn("\nДобавление 10000 элементов в arrayList. "+t);
        for (int i = 0; i < 10000; i++) {linkedList.add(5,i);}
        prn("Добавление 10000 элементов в linkedList. "+t);
        for (int i = 0; i < 10000; i++) {hashSet.add(i);}
        prn("Добавление 10000 элементов в hashSet. "+t);
        for (int i = 0; i < 10000; i++) {treeSet.add(i);}
        prn("Добавление 10000 элементов в treeSet. "+t);

        //удаление
        while (arrayList.size()>10) {arrayList.remove(0);}
        prn("\nУдаление из arrayList. "+t);
        while (linkedList.size()>10) {linkedList.remove(0);}
        prn("Удаление из linkedList. "+t);
        for (Iterator<Integer> it=hashSet.iterator();it.hasNext();)
        {
            it.next();
            it.remove();
        }
        prn("Удаление из hashSet. "+t);
        for (Iterator<Integer> it=treeSet.iterator();it.hasNext();)
        {
            it.next();
            it.remove();
        }
        prn("Удаление из treeSet. "+t);
        for (Iterator<Integer> it=treeSet.iterator();it.hasNext();) {it.remove();}
        prn("Удаление из treeSet. "+t);

    }

    //вспомогательный nested-класс для измерения быстродействия
    public static class Timer{
        private  long iniTime;
        private  Double Delta;
        public Timer(){
            iniTime=System.nanoTime();
        }
        public  String toString(){
            Delta=(double)(System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();

            return "Прошло "+Delta.toString()+" микросекунд.";
        }

    }



}
