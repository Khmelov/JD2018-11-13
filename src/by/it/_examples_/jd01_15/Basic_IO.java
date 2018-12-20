package by.it._examples_.jd01_15;

import java.io.*;
import java.util.*;

public class Basic_IO {
    public static void main(String[ ] args) throws IOException {
        String src=System.getProperty("user.dir")+"\\src\\by\\it\\examples\\jd01_15";

        String fileInTxt = src+"\\in.txt";
        System.out.println(src);
        //объявим коллекцию строк, со своим вариантом преобразования в строку
        List<String> txtLn=new ArrayList<String>(){
            @Override //вспомогательный анонимный класс,
                      //для вывода коллекции в нужном нам формате
                      //добавлено для повторения этого материала
            public String toString() {
                int n=0;
                StringBuilder out = new StringBuilder();
                for (String s:this) {
                    out.append(n).append(": ").append(s).append("\n"); n++;}
                return out.toString();
            }
        };

        //Пример 1.
        //чтение текстового файла в подготовленную выше коллекцию
        try (BufferedReader bufferedReader=
               new BufferedReader(
                   new FileReader(fileInTxt))){
            String line;
            //пока линия читается, присвоим ее и тут же сравним с null
            while ((line = bufferedReader.readLine())!=null){
                  txtLn.add(line); //линия прочиталась. Добавим ее в коллекцию
            }
        } catch (IOException e) {
            throw new IOException("Not read "+fileInTxt,e);
        }


        //Пример 2.
        //вывод данных через PrintWriter (в текстовый файл)
        String fileOutTxt = src+"JD01_15/out.txt";
        try (PrintWriter printer=
                new PrintWriter(
                    new FileWriter(fileOutTxt, true))){
            printer.println(txtLn);  //тут что-то печатаем, для примера - все ту же коллекцию
                                     //обратите внимание как она выводится.
            System.out.print(txtLn); //для этого продублируем на консоль
                                     //так работает наш анонимный класс.
        } catch (IOException e) {
            throw new IOException("Not write "+fileOutTxt,e);
        }

        //Пример 3.
        //Теперь давайте сохраним что-то чуть посложнее. Например, случайно заполненный hashMap.
        HashMap<Integer,String> hm=new HashMap<>();
        for (int i = 0; i < 5; i++)
        {
            int key=(int)(Math.random()*50);
            String value="строка"+i;
            hm.put(key,value);
        }

        String fileOutHashMapTxt = src+"JD01_15/hashmap.txt";
        try (PrintWriter printer=
               new PrintWriter(
                   new FileWriter(fileOutHashMapTxt))){
            Iterator it=hm.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair=(Map.Entry)it.next();
                //сохранение возможно в произвольном формате
                //здесь это ini (пара ключ:значение)
                printer.println(pair.getKey()+":"+pair.getValue());
            }


        } catch (IOException e) {
            throw new IOException("Not write "+fileOutHashMapTxt,e);
        }

    }
}
