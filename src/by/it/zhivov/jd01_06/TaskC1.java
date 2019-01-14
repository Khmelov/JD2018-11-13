package by.it.zhivov.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] lines = Poem.text.split("\n");
        StringBuilder[] lb = new StringBuilder[lines.length];
        for (int i = 0; i < lines.length; i++) {
            lb[i] = new StringBuilder(lines[i]);
        }
        int maxlen = 0;
        for (int i = 0; i <lines.length; i++) {
            if(lines[i].length()>maxlen) maxlen = lines[i].length();
        }
        for (int i = 0; i < lb.length; i++) {
            int counter = 0;
            while(lb[i].length() < maxlen) {
                counter = 0;
                while (counter<lb[i].length()) {
                    int a = lb[i].length();
                    if (lb[i].charAt(counter) == ' ' && lb[i].charAt(counter + 1) != ' ') {
                        lb[i].insert(counter, " ");
                        counter +=2;
                    } else ++counter;
                    if(lb[i].length() == maxlen) break;
                }
            }
        }
        for (int i = 0; i < lb.length-1; i++) {
            lb[i].append("\n");
        }
        for (int i = 0; i < lb.length; i++) {
            System.out.print(lb[i]);
        }
    }
}
