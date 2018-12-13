package by.it.vchernetski.jd01_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    private static boolean check(String line){
        HashMap<Character, Character> br = new HashMap<>();
        br.put('(',')');
        br.put('{','}');
        br.put('[', ']');
        line = line.replaceAll("[^{}()\\[\\]]+","");
        char[] mas = line.toCharArray();
        if(mas.length%2!=0) return false;
        ArrayList<Character> fin = new ArrayList<>();
        for (char b: mas) {
            if(b=='{'||b=='('||b=='[') {
                fin.add(b);
                continue;
            }
            if(fin.size()==0) return false;
            if(!(b==br.get(fin.get(fin.size()-1)))) return false;
            if(b==br.get(fin.get(fin.size()-1))) fin.remove(fin.size()-1);
        }
        return (fin.size()==0);
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(inputStreamReader);
        String line=reader.readLine();
        System.out.println(check(line));
    }
}
