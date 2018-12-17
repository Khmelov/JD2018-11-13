package by.it.kovalyova.jd01_15;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//simple comment
//else

/*
multi
line
comment
*/
public class TaskB {

    public static void main(String[] args) {
        try {
            String filename = System.getProperty("user.dir") + "\\src\\" + TaskB.class.getName().replace(".", File.separator);
            String fname_in = filename + ".java";
            String fname_out = filename + ".txt";
            StringBuilder src = new StringBuilder();
            Scanner sc = new Scanner(new File(fname_in));
            Boolean incomment = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().startsWith("/"+"/")) {
                    src.append(System.getProperty("line.separator"));
                    continue;
                }
                if (line.trim().startsWith("/"+"*")) incomment = true;
                if (!incomment) {
                    src.append(line+System.getProperty("line.separator"));
                } else {
                    src.append(System.getProperty("line.separator"));
                }
                if (line.trim().startsWith("*"+"/")) {
                    incomment = false;
                }
            }

            PrintWriter out = new PrintWriter(new FileWriter(fname_out));
            System.out.print(src);
            out.print(src);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
com
ment
 */