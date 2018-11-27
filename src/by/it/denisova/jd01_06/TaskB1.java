package by.it.denisova.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("([\\s,.?!:]|-)+");
        for (int i = 0; i <words.length ; i++) {
            check(words[i]);
        }
    }
    private static boolean check(String word){
      char[] gl = {'а', 'е'};
        word = word.toLowerCase();
        return !contains(gl, word.charAt(0)) && contains(gl, word.charAt(word.length() - 1));
    }

    private static boolean contains(char[] chars, char character){
        boolean result = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character) {
                result = true;
            }
        }
        return result;
    }
}
