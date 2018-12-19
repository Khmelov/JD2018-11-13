package by.it.naumenko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {




        private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {



        readFile();
        writeFile();

    }

    private static void readFile() throws IOException {
        //try (FileReader fileReader = new FileReader(Util.getPath("text.txt"));
        try (FileReader fileReader = new FileReader(dir(TaskB.class) + "text.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int b;
            while ((b = bufferedReader.read()) != -1) {
                stringBuilder.append((char)b);
            }
            Pattern pattern = Pattern.compile("[А-Яа-яёЁ]+");
            Matcher matcher = pattern.matcher(stringBuilder);
            int countWords = 0;
            while (matcher.find()) {
                countWords++;
            }
            Pattern pattern1 = Pattern.compile("[,.!?:;]");
            Matcher matcher1 = pattern1.matcher(stringBuilder);
            int countPunctuation = 0;
            while (matcher1.find()) {
                countPunctuation++;
            }
            System.out.print("words=" + countWords  + ", punctuation marks=" + countPunctuation);
        }
    }

    private static void writeFile() throws IOException {
        //try (FileWriter fileWriter = new FileWriter(Util.getPath("resultTaskB.txt"));
        try (FileWriter fileWriter = new FileWriter(dir(TaskB.class) + "resultTaskB.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            Pattern pattern = Pattern.compile("[А-Яа-яёЁ]+");
            Matcher matcher = pattern.matcher(stringBuilder);
            int countWords = 0;
            while (matcher.find()) {
                countWords++;
            }
            Pattern pattern1 = Pattern.compile("[,.!?:;]");
            Matcher matcher1 = pattern1.matcher(stringBuilder);
            int countPunctuation = 0;
            while (matcher1.find()) {
                countPunctuation++;
            }

            bufferedWriter.write("words=");
            bufferedWriter.write(String.valueOf(countWords));
            bufferedWriter.write(", punctuation marks=");
            bufferedWriter.write(String.valueOf(countPunctuation));
        }
    }
}

