package by.it.malishevskiy.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        TaskA2.parseToWords(Poem.text);
        String[] words = TaskA2.getStrings();
        for (String word : words) {
            if (word.length() > 1) {
                if (!isVowel(word.charAt(0))) {
                    if (isVowel(word.charAt(word.length() - 1))) {
                        System.out.println(word);
                    }
                }
            }
        }
    }

    private static boolean isVowel(char ch) {
        return "аеёиоуыэюяАЕЁИОУЫЭЮЯ".indexOf(ch) != -1;
    }
}