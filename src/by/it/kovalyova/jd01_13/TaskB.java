package by.it.kovalyova.jd01_13;


    import java.text.ParseException;
    import java.util.Scanner;

    public class TaskB {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = "";
            double res = 0;
            try {
                while (!((s = sc.next()).equals("END"))) {
                    double num = Double.parseDouble(s);
                    if (num<0) throw new ArithmeticException();
                    System.out.println(num);
                    System.out.println(Math.sqrt(res += num));
                }
            }catch(Exception e){
                StackTraceElement[] stckTrElem = e.getStackTrace();
                for (StackTraceElement element : stckTrElem) {
                    if (TaskB.class.getName().equals(element.getClassName())){
                        String name = e.getClass().getName();
                        String clName = element.getClassName();
                        int num = element.getLineNumber();
                        System.out.printf(" name: %s \n class: %s \n line: %d", name, clName, num);
                        break;
                    }
                }
            }
        }
}
