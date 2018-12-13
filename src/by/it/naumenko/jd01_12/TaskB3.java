package by.it.naumenko.jd01_12;

import java.util.*;

public class TaskB3 {

    private static String nameGenerate(String str, char[] sumbol){
        StringBuilder stringBuilder = new StringBuilder();
        int n = (int) (Math.random()*10);
        for (int j = 0; j < n ; j++) {
            int r = (int) (Math.random()*10+26-10);
            stringBuilder.append(sumbol[r]);
        }
        return stringBuilder.toString();
    }

    private static String process(ArrayList<String> peoples){
        int index=0;
        while (peoples.size()>1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                index++;
                if(index%2==0)
                    iterator.remove();
            }
        }
        return  peoples.get(0);
    }

    private static String process(LinkedList<String> peoples){
        int index=0;
        while (peoples.size()>1) {
            //peoples.

            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                index++;
                if(index%2==0)
                    iterator.remove();
            }
        }
        return  peoples.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] sumbol = new char[str.length()];
        for (int i = 0; i < sumbol.length; i++) {
            sumbol[i]=str.charAt(i);
        }
        System.out.println("сколько человек в вашем списке?");
        int n = scanner.nextInt();
        List<String> name = new ArrayList<>();
        List<String> name1 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            name.add(nameGenerate(str,sumbol));
            name1.add(nameGenerate(str,sumbol));
        }

        System.out.println("ArrayList: "+"\n"+name);
        System.out.println("LinkedList: "+"\n"+name1);

        System.out.println("Остался в ArrayList "+process((ArrayList<String>) name));
        System.out.println("Остался в LinkedList "+process((LinkedList<String>) name1));



    }
}
