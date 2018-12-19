package by.it.karnilava.jd01_12;




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static Map<String, Integer> word = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();



        while (!str.equals("end")) {

            Pattern pattern = Pattern.compile("[a-zA-Z']+");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String wrd = matcher.group();

                if (word.containsKey(wrd)){
                   int count =  word.get(wrd);
                   word.put(wrd,count+1);

                }
                else {word.put(wrd,1);}



            }
            str = scan.nextLine();
        }

        System.out.println(word);
    }

}
