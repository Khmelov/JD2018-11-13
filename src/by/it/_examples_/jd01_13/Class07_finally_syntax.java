package by.it._examples_.jd01_13;

public class Class07_finally_syntax {

    public static class OneClassException extends Throwable{};
    public static class TwoClassException extends Throwable{};

    public static void main(String[ ] args) {

        try
        {
            /* код, который может вызвать исключение */
            if (Math.random()>0)
            {throw new OneClassException();}
            else
            {throw new TwoClassException();}
        }
        catch(OneClassException e)
        {
            /* обработка исключения */
        }
        catch(TwoClassException e)
        {
            /* обработка исключения */ // необязателен
        }
        finally {
            /* выполняется или после try, или после catch */
        }
    }


}
