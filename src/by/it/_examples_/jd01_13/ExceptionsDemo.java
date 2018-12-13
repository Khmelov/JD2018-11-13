package by.it._examples_.jd01_13;

public class ExceptionsDemo {
    public static void main(String args[ ]) {
        try {
            double invi;
            for (int i = -3; i < 4; i++) {
                invi=1/i;
                System.out.println("i="+i+" 1/i="+invi);
            }
        }
        catch (Exception e) {
            System.out.println("|e|="+e);
            System.out.println("|e.getMessage()|="          +e.getMessage());
            System.out.println("|e.getStackTrace.length|="  +e.getStackTrace().length);
            System.out.println("|e.getStackTrace|="         +e.getStackTrace());
            for (int j = 0; j < e.getStackTrace().length; j++) {
                System.out.println("|e.getStackTrace["+j+"]|="+e.getStackTrace()[j]);
            }
            System.out.println("|e.printStackTrace|");
            e.printStackTrace();
        }
    }
}
