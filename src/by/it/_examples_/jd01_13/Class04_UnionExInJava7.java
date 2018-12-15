package by.it._examples_.jd01_13;

public class Class04_UnionExInJava7 {

    private static final String CLASS_TO_LOAD = "main.java.Utils";
    public static void main(String[] args) {
            try {
                Class loadedClass = Class.forName(CLASS_TO_LOAD);
                System.out.println("Class " + loadedClass + " found successfully!");
                loadedClass.newInstance();

            }
                catch(NumberFormatException | ClassNotFoundException |
                     IllegalAccessException | InstantiationException e) {
                     e.printStackTrace();
            }

    }
}
