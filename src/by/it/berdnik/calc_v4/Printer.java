package by.it.berdnik.calc_v4;

class Printer {
    private Logger logger = Logger.getInstance();
    public void print(String res) {
        System.out.println(res);
        logger.log(res);  /* Итог.рез. */

    }
}
