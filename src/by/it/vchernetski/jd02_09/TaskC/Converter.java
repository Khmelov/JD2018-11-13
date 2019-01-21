package by.it.vchernetski.jd02_09.TaskC;


import java.io.*;

public abstract class Converter {
    protected Object obj;
    protected Class beanClass;
    public abstract String getText();
    public abstract void load(String str);
    public void save(File file){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(getText());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void load(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            StringBuilder sb = new StringBuilder();
            while(reader.ready()){
                sb.append(reader.readLine());
            }
                load(sb.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Converter(Class cl){beanClass=cl;}
    public void clearBean(){
        obj = new Object();
    }
}
