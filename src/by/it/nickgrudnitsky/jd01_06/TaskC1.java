package by.it.nickgrudnitsky.jd01_06;


public class TaskC1 {
    public static void main(String[] args) {

        String[] strings = Poem.text.split("\n");
        textFormst(strings);



        /*StringBuilder sentenses = new StringBuilder(Poem.text);
        String[] strings = getStrings(sentenses);
        int max = 0;
        for (String string : strings) {
            if (string.length() > max) {
                max = string.length();
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length()<max){
                String[] words = strings[i].split(" ");
                int amountOfSpases = words.length -1;
                int spases,firstSpease;
                if ((max-strings[i].length())%amountOfSpases==0){
                     spases = (max - strings[i].length())/amountOfSpases;
                     firstSpease = spases;
                } else {
                     spases = (max - strings[i].length())/amountOfSpases;
                     firstSpease = spases+(max - strings[i].length())%amountOfSpases;
                }
                Pattern pattern = Pattern.compile(" ");
                Matcher matcher = pattern.matcher(strings[i]);
                while (matcher.find()){
                    matcher.group().replaceAll(" ", "[ ]{1+spases}");
                }

            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
        System.out.println(max);
    }

    private static String[] getStrings(StringBuilder sb) {
        String[] string = new String[0];
        //Pattern pattern = Pattern.compile("[А-ЯЁ](\\.\\.\\.|[^.!?])*[.!?]");
        Pattern pattern = Pattern.compile(".+\\n");
        Matcher matcher = pattern.matcher(sb);
        int i=0;
        while (matcher.find()){
            int last = string.length;
            string = Arrays.copyOf(string, last+1);
            string[i] = matcher.group();
            i++;
        }
        return string;*/
    }

    private static void textFormst(String[] strings) {
        int length = getLength(strings);
        for (String string1 : strings) {
            String[] string = string1.split(" ");
            int senteseLength = 0;
            int numOfSpases = string.length - 1;
            for (String s : string) {
                senteseLength += s.length();
            }
            int amountOfSpases = length - senteseLength;
            int spases = amountOfSpases / numOfSpases;
            int extraSpase = amountOfSpases % numOfSpases;
            StringBuilder sb = new StringBuilder();
            for (int i1 = 0; i1 < string.length; i1++) {
                sb.append(string[i1]);
                if (i1 != string.length - 1) {
                    for (int i2 = 0; i2 < spases; i2++) {
                        sb.append(" ");
                    }
                    if (extraSpase > 0) {
                        sb.append(" ");
                        extraSpase--;
                    }
                }
            }
            System.out.println(sb);
        }
    }

    private static int getLength(String[] strings) {
        int maxLength = 0;
        for (String string : strings) {
            if (string.length() > maxLength) {
                maxLength = string.length();
            }
        }
        return maxLength;
    }
}
