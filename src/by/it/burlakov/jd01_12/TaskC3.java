package by.it.burlakov.jd01_12;


import java.util.*;

public class TaskC3 {

    private static List<Character> openBr = new ArrayList<>(Arrays.asList('(', '{', '['));
    private static String REGEXP = "[^{}\\[\\]()]+";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Ваша строка - " + line);

        String string = line.replaceAll(REGEXP, "");

        System.out.println(check(string));

        //test
        String ex1 = "Пример 1 : ( [ { < > } ] ) ожидаемый результат - true.";
        String ex2 = "Пример 2 : ( [ { ] } ) ожидаемый результат - false.";
        String ex3 = "Пример 3 : ((( )( ))( )), ожидаемый результат – true";
        String ex4 = "Пример 4 : )(((())) ожидаемый результат - false.";
        String ex5 = "Пример 5 : {}[]()(()[]) ожидаемый результат - true.";
        String ex6 = "Пример 5 : (}{), ожидаемый результат - false.";
        ArrayList<String> test = new ArrayList<>(Arrays.asList(ex1, ex2, ex3, ex4, ex5, ex6));

        for (String str : test){
            str = str.replaceAll(REGEXP, "");
            System.out.println(str + " " + check(str));
        }
    }

    private static boolean check(String line) {
        char[] brackets = line.toCharArray();

        LinkedList<Character> stack = new LinkedList<>();

        for(char ch : brackets ){
            if(openBr.contains(ch)){
                switch (ch){
                    case '(': stack.addLast(')'); break;
                    case '{': stack.addLast('}'); break;
                    case '[': stack.addLast(']'); break;
                }
            } else {
                if(stack.isEmpty()){
                    return false;
                } else if (!stack.peekLast().equals(ch)){
                    return false;
                }
                stack.removeLast();
            }
        }
        return stack.isEmpty();
    }
}