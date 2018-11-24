package by.it.evenchik.jd01_02;

public class Rgen {


        public static int getRandomIntegerBetweenRange(int min, int max){
            int x = (int)(Math.random()*((max-min)+1))+min;
            return x;
        }

}

