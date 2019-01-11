package by.it.karnilava.jd02_03;
import java.util.Random;

class Rnd {
    static final long init = System.currentTimeMillis();
    static final Random random = new Random(init);

    static int fromTo (int from, int to) {
        int delta = to-from+1;
        int msWait = from+random.nextInt(delta);
        return msWait;
    }

}
