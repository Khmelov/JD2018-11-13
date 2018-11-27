package by.it.lobkova.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String[] text = sb.toString().split("[;.!?]+");
        int last = text.length - 1;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < last; i++) {
                if (text[i].length() > text[i + 1].length()) {
                    String buff = text[i];
                    text[i] = text[i + 1];
                    text[i + 1] = buff;
                    flag = true;
                }
            }
            last--;
        }
        while (flag);

        for (int i = 0; i < text.length; i++) {
            myTrim(text[i]);
        }
    }

    private static String myTrim(String str) {
        int i = 0;
        while (i < str.length()) {
            if (!Character.isLetter(str.charAt(i)) && (str.charAt(i) != ' ')) {
                str = str.replace(str.charAt(i), ' ');
            }
            i++;
        }
        str = str.trim();

        str = str.replaceAll("\\s+", " ");

        System.out.println(str);

        return str;
    }
}
