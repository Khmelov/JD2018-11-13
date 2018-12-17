package by.it.vchernetski.jd01_15;//asd
/*
asdas
 */
import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        StringBuilder finsb = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new FileReader(Util.getPath("TaskB.java")))){
            while (rd.ready()){//0 comment
                //1 comment
                char temp = (char)rd.read();
                if(temp == '/'){
                    char a = (char)rd.read();
                    switch (a) {
                        case '/':
                            while(rd.ready()){
                                char b = (char)rd.read();
                                if(b=='\n'){
                                    break;
                                }
                            }
                            finsb.append("\n");
                            break;
                        case '*':
                            //2comment
                            while(rd.ready()){
                                if(((char)rd.read())=='*'&&((char)rd.read())=='/'){
                                    break;
                                }
                                /*
                                3 comment
                                 */
                            }
                            break;
                        default:
                            finsb.append(temp);
                            finsb.append(a);
                            break;
                        /*
                        4 comment
                         */
                    }
                    continue;
                }
                /**
                 * JavaDoc
                 */
                finsb.append(temp);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try(BufferedWriter out = new BufferedWriter(new FileWriter(Util.getPath("TaskB.txt")))){
            out.write(finsb.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(finsb.toString());
    }
}
