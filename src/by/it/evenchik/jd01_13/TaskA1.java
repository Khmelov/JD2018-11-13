//package by.it.evenchik.jd01_13;
//
//
//import jdk.jfr.StackTrace;
//
//import java.util.HashMap;
//
//public class TaskA1 {
//    public static void main(String[] args) {
//        if(Math.random()>0.5)
//            new HashMap<String, String>(null);
//        else Integer.parseInt("hello");
//    }catch (NullPointerException| NumberFormatException e) {
//        String name = e.getClass().getName();
//        StackTraceElement[] stackTrace = e.getStackTrace();
//        for (StackTraceElement element : StackTrace){
//            System.out.println(element);
//        }
//
//    }
//
//}
