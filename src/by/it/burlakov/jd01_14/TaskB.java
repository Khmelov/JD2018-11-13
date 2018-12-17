package by.it.burlakov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static int countWord = 0;
    private static int countMark = 0;
    private static String WORD_REGEXP = "[а-яёА-ЯЁ]+";
    private static String MARK_REGEXP = "[^а-яёА-ЯЁ\\s]+";

    public static void main(String[] args)  {

        StringBuilder sb = new StringBuilder();
        String pathRead = Util.getPath("text.txt", false);
        String pathWrite = Util.getPath("resultTaskB.txt", false);

        try {

            countingWords_Marks(readFile(sb, pathRead));

            String resultString = "words=" + countWord + ", punctuation marks=" + countMark;

            printToConsole(resultString);
            printToFile(resultString, pathWrite);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static StringBuilder readFile(StringBuilder sb, String path) throws IOException {

        try ( BufferedReader in = new BufferedReader(new FileReader(path)) )
        {
            String line;
            while((line = in.readLine()) != null){
                sb.append(line).append("\n");
            }
        }
        return sb;
    }

    private static void countingWords_Marks(StringBuilder sb){
        Pattern patternWord = Pattern.compile(WORD_REGEXP);
        Matcher matcherWord = patternWord.matcher(sb);

        Pattern patternMark = Pattern.compile(MARK_REGEXP);
        Matcher matcherMark = patternMark.matcher(sb);

        for (int i = 0; i < sb.length(); i++) {
            if(matcherWord.find()){
                countWord++;
            } else if(matcherMark.find()){
                countMark++;
            }
        }
    }

    private static void printToConsole(String string){
        System.out.println(string);
    }

    private static void printToFile(String string, String path) throws IOException {

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.print(string);
        }
    }
}
