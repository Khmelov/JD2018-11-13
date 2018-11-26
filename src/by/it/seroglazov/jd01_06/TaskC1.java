package by.it.seroglazov.jd01_06;

import java.util.Arrays;

public class TaskC1 {
    public static void main(String[] args) {
        String[] strings = Poem.text.split("\n");
        int maxLength = 0;
        for (String string : strings) {
            if (string.length() > maxLength) maxLength = string.length();
        }
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i].replace(" +", " ").trim();
            String[] words = str.split(" ");
            int numSpace = words.length - 1; // Number of spaces in the string
            int numAdd = maxLength - str.length(); // Number of spaces we need to add to the string
            int numToAddInAllPlaces = numAdd / numSpace; // That amount of spaces we need to add to every place between words
            int numExtraSpaces = numAdd % numSpace; // That extra amount of spaces we need to add in first, second ... places (by 1)
            char[] ch = new char[numToAddInAllPlaces + 1]; // One native space and numToAddInAllPlaces added
            Arrays.fill(ch, ' ');
            String spaces = new String(ch); // String like "    ".
            StringBuilder sb = new StringBuilder(maxLength);
            int extraAdded = numExtraSpaces; // An extra spaces amount we have to add
            for (int j = 0; j < words.length; j++) {
                sb.append(words[j]);
                if (j != words.length - 1) {
                    sb.append(spaces);
                    if (extraAdded > 0) {
                        sb.append(' ');
                        extraAdded--;
                    }
                }
            }
            strings[i] = sb.toString();
        }
        for (String string : strings) System.out.println(string);
    }
}