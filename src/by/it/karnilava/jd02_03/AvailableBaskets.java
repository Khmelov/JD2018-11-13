package by.it.karnilava.jd02_03;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class AvailableBaskets {

     static final BlockingQueue<Integer> availableBaskets = new ArrayBlockingQueue<Integer>(50);


        AvailableBaskets () {

            for (int i = 1; i <= 50; i++) {


                availableBaskets.add(i);

            }
        }
    }


