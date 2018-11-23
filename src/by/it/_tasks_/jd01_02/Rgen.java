package by.it._tasks_.jd01_02;
import java.lang.Math;

public class Rgen {


        public static int getRandomIntegerBetweenRange(int min, int max){
            int x = (int)(Math.random()*((max-min)+1))+min;
            return x;
        }

}

