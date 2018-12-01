package by.it.malishevskiy.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    class Vector extends Var {//Наследуем класс Vector от Var
        private double[] value;//Создаем дабловый массив value
        Vector(double[] value){
            this.value = new double[value.length];//Говорим, что value равен вектору value
            System.arraycopy(value,0,this.value,0,value.length);//Копируем массив
        }
        Vector(Vector newVector){
            this.value = new double[newVector.value.length];

            System.arraycopy(newVector.value,0,this.value,0,newVector.value.length);
        }

        Vector(String strvalue){
            Matcher m = Pattern.compile("(\\d+[\\.\\d+]?)").matcher(strvalue);
            int size = 0;
            while(m.find()){
                size++;
            }
            value = new double[size];
            size = 0;
            m.reset();
            while (m.find()){
                value[size++] = Double.parseDouble(m.group());
            }
        }

        public String toString(){
            StringBuilder sb = new StringBuilder("{");
            String del=", ";
            for (int i = 0; i < value.length; i++) {
                sb.append(value[i]).append(del);
                if(i == value.length-2) del = "}";
            }
            return sb.toString();
        }
    }