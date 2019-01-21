package by.it.seroglazov.jd02_09.converter;

import java.io.*;

public abstract class Converter {
    protected Object bean;
    protected Class beanClass;

    public Converter(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void save(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            String str = getText();
            bw.write(str);
        } catch (IOException e) {
            System.out.println("Can't write file " + file.getName());
        }
    }

    public void load(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            br.lines().forEach(sb::append);
            load(sb.toString());
        } catch (IOException e) {
            System.out.println("Can't read file " + file.getName());
        }
    }

    public abstract String getText();

    public abstract void load(String str);

}
