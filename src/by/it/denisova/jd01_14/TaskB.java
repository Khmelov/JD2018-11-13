package by.it.denisova.jd01_14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) throws Exception {
        String text = Util.getPath("text.txt");
        String filename = Util.getPath("resultTaskB.txt");

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> symbol = new ArrayList<>();

        String contents = readUsingScanner(text);

        textToArray(contents, words, symbol);
        writeNumbers(filename, textToArray(contents, words, symbol));
    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }

    private static void writeNumbers(String filename, String string) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        try(FileWriter writer = new FileWriter("resultTaskB.txt", false))
        {
            writer.write(string);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String textToArray(String str, ArrayList<String> arr, ArrayList<String> arr2) {
        StringBuilder jj = new StringBuilder(str);
        int count = 0;
        int count2 = 0;

        //String[] kk = jj.toString().split("\\W+");
        String[] split = str.split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");

        for (int i = 0; i < split.length; i++) {
            Matcher m = Pattern.compile("[а-яА-яёЁ]+").matcher(split[i]);
            m.reset();
            if (m.find()) {
                arr.add(m.group());
                count++;
            }
        }
        System.out.println("words=" + count);
        for (int i = 0; i < split.length; i++) {
            Matcher m = Pattern.compile("\\p{Punct}").matcher(split[i]);
            m.reset();
            if (m.find()) {
                arr2.add(m.group());
                count2++;
            }
        }
        System.out.println("marks=" + count2);
        String result = "words=" + count + ", " + "punctuation marks=" + count2;

        return result;
    }
}