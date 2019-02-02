package by.it.zhivov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/zhivov/";
        String filename = src + "jd01_14/text.txt";


        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String res = bufferedReader.readLine();
        int count = 0;
        int countPunctuation = 0;
        while (res != null) {

            Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher m = p.matcher(res);


            while (m.find()) {
                count++;
            }

            Pattern punct = Pattern.compile("[\\p{Punct}]+");
            Matcher mPunct = punct.matcher(res);

            while (mPunct.find()) {
                countPunctuation++;
            }

            res = bufferedReader.readLine();
        }
        System.out.println("words=" + count);
        System.out.println("punctuation marks=" + countPunctuation);


        String filename1 = src + "jd01_14/resultTaskB.txt";
        File f1 = new File(filename1);
        f1.getParentFile().mkdirs();
        f1.createNewFile();

        DataOutputStream dos1 = null;
        try {
            dos1 = new DataOutputStream(new FileOutputStream(f1));


            dos1.writeBytes("\n");
            dos1.writeBytes("words=" + count);
            dos1.writeBytes("\n");
            dos1.writeBytes("punctuation marks=" + countPunctuation);


        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename1);
        } finally {
            if (dos1 != null) {
                dos1.close();
            }



        }
    }
}
