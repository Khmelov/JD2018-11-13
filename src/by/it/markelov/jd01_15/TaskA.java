package by.it.markelov.jd01_15;


import java.io.*;

public class TaskA {
    public static File pathOfThisDirectory(Class<?> cl) {
        Package aPackage = cl.getPackage();//пакет
        String namePackage = aPackage.getName();//имя пакета
        String pathPackage = namePackage.replaceAll("\\.", "\\\\");//замена точек на \
        String property = System.getProperty("user.dir");//путь к папке проекта
        File file = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator);//объект класса File (путь к рабочей папке)
        return file;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + (int) (Math.random() * 31);
            }
        }

        File  pathOfThisDirectory= pathOfThisDirectory(TaskA.class);

        try (PrintWriter pr = new PrintWriter(pathOfThisDirectory+File.separator+"matrix.txt")) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    pr.printf("%3d ", matrix[i][j]);
                }
                pr.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(pathOfThisDirectory+File.separator+"matrix.txt"))) {
            while (br.ready()) {
                String s = br.readLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
