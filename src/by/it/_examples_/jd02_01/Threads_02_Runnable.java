package by.it._examples_.jd02_01;

class Threads_02_Runnable {

    static class MyRunnable implements Runnable {
        String name;

        MyRunnable(String name) {
            this.name = name;
            //а здесь суперклассом будет Object а не Thread
            //поэтому делаем свое поле для имени потока
        }


        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println(name+" is run. loop:"+i);
                try {
                    //методы sleep и yield из предыдущего примера у запускаемого
                    //экземпляра отсутствуют и их нельзя вызвать по имени
                    //НО! sleep и yield - статические в классе Thread,
                    //поэтому их можно все равно вызвать
                    Thread.sleep(3);
                    Thread.yield();
                } catch (InterruptedException e) {
                    System.err.println(e.toString());
                }
            }
        }
    }

    //это обычный основной поток приложения
    public static void main(String[ ] args) throws InterruptedException {
        //создадим объекты, готовые к запуску в потоке
        MyRunnable one=new MyRunnable("one");
        MyRunnable two=new MyRunnable("--two");
        //one.run(); // выполнится метод, НО ТАК поток не запустится!

        //создаем потоки
        Thread th1 = new Thread(one);
        Thread th2 = new Thread(two);
        System.out.println("one:" + th1.getState() + " two:" + th2.getState());

        //запускаем потоки
        th1.start();
        th2.start();
        System.out.println("one:" + th1.getState() + " two:" + th2.getState());

        //приостановка главного потока, пока не завершатся два созданных
        th2.sleep(3000); //порядок приостановки неважен

//        th1.join(); //потому что, см. ниже
        System.out.println("one:" + th1.getState() + " two:" + th2.getState());
        System.out.println("Все потоки завершены");
//        th1.join(); //методы join доступны даже после завершения потока
//        th2.join(); //т.к. экземпляры завершенных объектов еще есть в памяти
                    //но они мгновенно отдают управление
        System.out.println("Конец");

    }


}
