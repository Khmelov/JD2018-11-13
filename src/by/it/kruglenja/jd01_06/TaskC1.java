package by.it.kruglenja.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static StringBuilder sb = new StringBuilder(Poem.text);
    private static int biggestLength;

    public static void main(String[] args) {
        String[] lines = sb.toString().split("\n");
        biggestLength = maxLength(lines);
        spacedPrint(lines);
    }

    private static int maxLength(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) maxLength = line.length();
        }
        return maxLength;
    }

    private static void spacedPrint(String[] lines) {
        for (String line : lines) {
            StringBuilder mLine = new StringBuilder();
            String[] sLine = line.split(" ");
            int lineLength = line.length();
            int wordCount = line.split(" ").length - 1;
            int spaceNeed = (biggestLength - lineLength) / (wordCount);
            int spaceRest = (biggestLength - lineLength) % (wordCount);
            int wordAdded = 0;
            for (String s : sLine) {
                mLine.append(s);
                int counter = spaceNeed;
                boolean fsingleSpace = true;
                while (counter >= 0 && wordAdded != wordCount) {
                    mLine.append(" ");
                    counter--;
                    if (spaceRest > 0 && fsingleSpace){
                        mLine.append(" ");
                        spaceRest--;
                        fsingleSpace = false;
                    }
                }
                wordAdded++;
            }
            System.out.println(mLine.toString());
        }
    }
}
