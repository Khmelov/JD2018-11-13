package by.it.skarpovich.jd01_06;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] getArray(String text) {
        StringBuilder sBuilder= new StringBuilder(text);
        Matcher matcher = Pattern.compile("([А-яё\\s]*[,:-]?([.]{3})?)*[\\.!?]").matcher(sBuilder);
        String[] sent=new String[0];
        while(matcher.find()){
            String[] lineTemp = new String[sent.length+1];
            System.arraycopy(sent,0,lineTemp,0,sent.length);
            String line = matcher.group();
            line=line.replaceAll("[\\s\\p{Punct}]+"," ");
            line=line.trim();
            lineTemp[sent.length]=line;
            sent=lineTemp;
        }
        return sent;
    }
    private static void sorting(String[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[j].length()<array[j-1].length()){
                    String lineTemp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=lineTemp;
                }
            }
        }
    }


    public static void main(String[] args) {
        String[] array = getArray(Poem.text);
        sorting(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}