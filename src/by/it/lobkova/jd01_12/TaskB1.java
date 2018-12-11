package by.it.lobkova.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static void print (HashMap<String, Integer> map){
        StringBuilder output = new StringBuilder();
        for(Map.Entry<String, Integer> m: map.entrySet()){
            output.append(m.getKey()+"="+m.getValue().toString()+"\n");
        }
        System.out.println(output);
    }
    public static void main(String[] args) {
        HashMap<String, Integer> mymap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String input;
        while(!((input=sc.next()).equalsIgnoreCase("end"))){
            Matcher m = Pattern.compile("[A-z]+[']?[a-z]+").matcher(input);
            m.reset();
            if(m.find())
                input = m.group();
            if(input.equalsIgnoreCase("isn't")) input = "don't";
            if(mymap.containsKey(input)) {
                Integer x =mymap.get(input);
                mymap.remove(input,x);
                mymap.put(input,++x);
                continue;
            }
            mymap.put(input,1);
        }
        print(mymap);
    }
}
