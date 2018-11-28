package by.it.evenchik.jd01_06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA2 {

    private static String[] w = {}; //masiv strok//
    private static int[] count = {};//masiv intov//



    ////zakinuli slovo iz matchera(odni slovo iz metoda groupp)
    private static int pos(String word){
        for (int i = 0; i < w.length; i++) { //perebiraem stroki dlya priverki na povtori
            if(w[i].equals(word))            //sravnivaem soderjimoe masiva strok "w" po indeksu "i" s slovom na vhode metoda "pos"
            return i;                        //vernulo index povtornogo elementa.
        }
        return -1;
    }
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher mathcer = pattern.matcher(Poem.text);
        while(mathcer.find()){
            String word = mathcer.group();
            int p = pos(word);
            if(p >= 0){
                count[p]++;

            }
            else{
                int last = w.length; //izmerili masiv i prisvoili dlinnu v intovuju peremenuyu last
                w = Arrays.copyOf(w, last + 1);  // skopirovsli  masiv iz starogo i uvelichili na odin element (stariy w ushel pod garbage collector)
                w[last] = word; //  zapisali slovo v mas "W" v index "last"
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;    /// soderjanie masiva so slovovom bez povtoreniy.

            }
        }
        for (int i = 0; i < w.length; i++) {
            System.out.println(w[i] + "=" + count[i]);
        }

    }
}