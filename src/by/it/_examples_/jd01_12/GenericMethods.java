package by.it._examples_.jd01_12;

public class GenericMethods {
    //параметризированный метод с одним параметром (String==выход)
    static <T> String genericMethodString(T in) {
        //do something
        return in.toString();
    }

    //параметризированный метод с одним параметром (вход==выход)
    static <T> T genericMethod1(T in) {
        //do something
        return in;
    }

    //параметризированный с двумя параметрами (вход!=выход)
    static <T, V> T genericMethod2(V in) {
        //do something
        return (T) in.toString(); //тут почти гарантированы ошибки времени выполнения
    }

    public static void main(String[] args) {
        String res;
        //вызов метода с одним параметром (вход==выход)
        res = "in float:" + GenericMethods.genericMethodString(12.123);
        System.out.println(res);
        //вызов метода с одним параметром (вход==выход)
        res = "in String:" + GenericMethods.genericMethod1("Привет");
        System.out.println(res);
        //вызов метода с двумя параметрами (вход!=выход)
        res = "in int:" + GenericMethods.<String,Integer>genericMethod2(123);
        System.out.println(res);
    }


}
