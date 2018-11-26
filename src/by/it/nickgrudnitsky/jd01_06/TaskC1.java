package by.it.nickgrudnitsky.jd01_06;

/*import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;*/

public class TaskC1 {
    public static void main(String[] args) {
        /*StringBuilder sentenses = new StringBuilder(Poem.text);
        String[] strings = getStrings(sentenses);
        int max = 0;
        for (String string : strings) {
            if (string.length() > max) {
                max = string.length();
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length()<max){
                String[] words = strings[i].split(" ");
                int amountOfSpases = words.length -1;
                int spases,firstSpease;
                if ((max-strings[i].length())%amountOfSpases==0){
                     spases = (max - strings[i].length())/amountOfSpases;
                     firstSpease = spases;
                } else {
                     spases = (max - strings[i].length())/amountOfSpases;
                     firstSpease = spases+(max - strings[i].length())%amountOfSpases;
                }
                Pattern pattern = Pattern.compile(" ");
                Matcher matcher = pattern.matcher(strings[i]);
                while (matcher.find()){

                }

            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
        System.out.println(max);
    }

    private static String[] getStrings(StringBuilder sb) {
        String[] string = new String[0];
        //Pattern pattern = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Pattern pattern = Pattern.compile(".+\\n");
        Matcher matcher = pattern.matcher(sb);
        int i=0;
        while (matcher.find()){
            int last = string.length;
            string = Arrays.copyOf(string, last+1);
            string[i] = matcher.group();
            i++;
        }
        return string;*/
    }
}
