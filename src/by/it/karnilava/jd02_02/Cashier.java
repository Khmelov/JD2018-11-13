package by.it.karnilava.jd02_02;


import java.util.Map;

import java.util.concurrent.atomic.AtomicInteger;


public class Cashier extends Thread implements Runnable, ICashier {

    private int numero;
    static AtomicInteger numberOfOpenCashdesks = new AtomicInteger(0);
    private static final Object lock = new Object();
    AtomicInteger grossIncome = new AtomicInteger(0);


    public Cashier(int numero) {
        this.numero = numero;
        this.setName("Cashier # " + numero + " ");
        numberOfOpenCashdesks.getAndAdd(+1);
        //System.out.println("Cashdesk # " + numero + " is open");
        //System.out.println();
        start();
    }


    @Override // кассир обслуживает покупаетелей
    public void run() {


        serve();


    }


    @Override

    // Обслуживание покупателей
    public void serve() {
        try {
            while (!Runner.isMarketClose()) {
                // Runner.time>120 || Runner.currentnumberOfBuyers.get() != 0

                Buyer currentBuyer = QueueOfPensioneers.queueOfPensioneers.poll();

                if (currentBuyer == null) {

                    currentBuyer = QueueToCashier.queueToCashier.poll();
                    if (currentBuyer == null) {
                        Cashier.sleep(1);
                        continue;
                    }
                }


                //else{


                // Один кассир проверяет размер очереди, если она больше, чем 5 человек на одного - зовет коллегу открыть кассу
                synchronized (lock) {
                    if ((QueueToCashier.queueToCashier.size() + QueueOfPensioneers.queueOfPensioneers.size()) > Cashier.numberOfOpenCashdesks.get() * 5 && Cashier.numberOfOpenCashdesks.get() <= 5) {

                        Integer numeroNuevo = AvailableCashdesks.availableCashdesks.poll();

                        if (numeroNuevo != null) {
                            new Cashier(numeroNuevo);
                        }

                    }
                }

                synchronized (lock) {
                    printInfo(this.numero, currentBuyer);
                }
                //  System.out.println("Now " + currentBuyer + "'s turn");
                //   System.out.println(currentBuyer + " goes to " + this.getName());
//                int sum = 0;
//                for (Map.Entry<Integer, Integer> element : currentBuyer.basketOfGoods.entrySet()) {
//                 //   System.out.println(this.getName() + " took a good # " + element.getKey() + " from the basket of " + currentBuyer + ", value - " + element.getValue());
//                    sum = sum + element.getValue();
//
//
//                }
                // System.out.println(currentBuyer + "'s check is " + sum + " dollars");
                Thread.sleep(Buyer.amountForCashier * 1000);

                // System.out.println("Serving " + currentBuyer + " by " + this.getName() + " is done");


                synchronized (currentBuyer) {
                    currentBuyer.notify();

                }

                // Если без текущего кассира на остальных будет меньше либо равно 5 человек на одного, то касса закрывается
                synchronized (lock) {
                    if ((QueueToCashier.queueToCashier.size() + QueueOfPensioneers.queueOfPensioneers.size()) <= 5 * (numberOfOpenCashdesks.get() - 1) && numberOfOpenCashdesks.get() > 1) {
                        AvailableCashdesks.availableCashdesks.add(numero);
                        //System.out.println("Cashdesk # " + numero + " is closed\n");

                        numberOfOpenCashdesks.getAndAdd(-1);
                        return;
                    }
                }
            }

            //}
        } catch (InterruptedException e) {
            System.out.println(this + " //некорректное завершение ожидания");
        }


    }


    public void printInfo(int numero, Buyer currentBuyer) {

        String delim = "|";
        int sum = 0;
        switch (numero) {

            case 1: {
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", currentBuyer + "'s check: " + delim, delim, delim, delim, delim, delim, delim);
                for (Map.Entry<Integer, Integer> element : currentBuyer.basketOfGoods.entrySet()) {
                    String line = "a good # " + element.getKey() + ", value - " + element.getValue();
                    System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", line + delim, delim, delim, delim, delim, delim, delim);
                    sum = sum + element.getValue();


                }
                grossIncome.getAndAdd(sum);
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", "Check is " + sum + " dollars" + delim, delim, delim, delim, delim, QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size() + delim, grossIncome + delim);
                break;
            }


            case 2: {
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, currentBuyer + "'s check: " + delim, delim, delim, delim, delim, delim);
                for (Map.Entry<Integer, Integer> element : currentBuyer.basketOfGoods.entrySet()) {
                    String line = "a good # " + element.getKey() + ", value - " + element.getValue();
                    System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, line + delim, delim, delim, delim, delim, delim);
                    sum = sum + element.getValue();


                }
                grossIncome.getAndAdd(sum);
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, "Check is " + sum + " dollars" + delim, delim, delim, delim, QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size() + delim, grossIncome + delim);
                break;
            }


            case 3: {
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, currentBuyer + "'s check: " + delim, delim, delim, delim, delim);
                for (Map.Entry<Integer, Integer> element : currentBuyer.basketOfGoods.entrySet()) {
                    String line = "a good # " + element.getKey() + ", value - " + element.getValue();
                    System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, line + delim, delim, delim, delim, delim);

                    sum = sum + element.getValue();


                }
                grossIncome.getAndAdd(sum);

                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, "Check is " + sum + " dollars" + delim, delim, delim, QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size() + delim, grossIncome + delim);
                break;
            }


            case 4: {
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, currentBuyer + "'s check: " + delim, delim, delim, delim);
                for (Map.Entry<Integer, Integer> element : currentBuyer.basketOfGoods.entrySet()) {
                    String line = "a good # " + element.getKey() + ", value - " + element.getValue();
                    System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, line + delim, delim, delim, delim);

                    sum = sum + element.getValue();


                }
                grossIncome.getAndAdd(sum);
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, "Check is " + sum + " dollars" + delim, delim, QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size() + delim, grossIncome + delim);
                break;
            }


            case 5: {
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, delim, currentBuyer + "'s check: " + delim, delim, delim);
                for (Map.Entry<Integer, Integer> element : currentBuyer.basketOfGoods.entrySet()) {
                    String line = "a good # " + element.getKey() + ", value - " + element.getValue();
                    System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, delim, line + delim, delim, delim);

                    sum = sum + element.getValue();


                }
                grossIncome.getAndAdd(sum);
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, delim, "Check is " + sum + " dollars" + delim, QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size() + delim, grossIncome + delim);
                break;
            }


            default: {
                System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", delim, delim, delim, delim, delim, delim, delim);
                break;
            }
        }
    }
}





