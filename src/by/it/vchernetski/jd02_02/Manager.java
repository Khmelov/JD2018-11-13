package by.it.vchernetski.jd02_02;

import java.util.Map;

public class Manager extends Thread {
    Manager() {
        super();
    }

    public void run() {
        int numofCahsier = 1;
        while (!Dispatcher.marketClosed()) {
            int buyers = QueueBuyer.sizePensioneer()+QueueBuyer.sizeNotPensioneer();
            if (buyers <= 5&& buyers!=0) {
                int index = 1;
                int count = 1;
                if (Market.cashiers.size() < index) {
                    for (int i = 1; i <= index; i++) {
                        Cashier cashier = new Cashier(numofCahsier++);
                        Thread thread = new Thread(cashier);
                        Market.cashiers.put(thread, true);
                        thread.start();
                    }
                } else {
                    for (Map.Entry<Thread, Boolean> entry : Market.cashiers.entrySet()) {
                        if (count <= index) {
                            synchronized (entry.getKey()) {
                                entry.getKey().notify();
                                entry.setValue(true);
                            }
                            continue;
                        } else {
                            if (entry.getValue()) {
//                                System.out.println(entry.getKey()+" closed");
                                synchronized (entry.getKey()) {
                                    try {
                                        entry.getKey().wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                entry.setValue(false);
                            }
                        }
                        count++;
                    }
                }
            }
            if (buyers > 5 && buyers <= 10) {
                int index = 2;
                int count = 1;
                if (Market.cashiers.size() < index) {
                    for (int i = 1; i <= index - Market.cashiers.size(); i++) {
                        Cashier cashier = new Cashier(numofCahsier++);
                        Thread thread = new Thread(cashier);
                        Market.cashiers.put(thread, true);
                        thread.start();
                    }
                } else {
                    for (Map.Entry<Thread, Boolean> entry : Market.cashiers.entrySet()) {
                        if (count <= index) {
//                            System.out.println(entry.getKey()+" closed");
                            synchronized (entry.getKey()) {
                                entry.getKey().notify();
                                entry.setValue(true);
                            }
                            continue;
                        } else {
                            if (entry.getValue()) {
                                System.out.println(entry.getKey()+" closed");
                                synchronized (entry.getKey()) {
                                    try {
                                        entry.getKey().wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                entry.setValue(false);
                            }
                        }
                        count++;
                    }
                }
            }
            if (buyers > 10 && buyers <= 15) {
                int index = 3;
                int count = 1;
                if (Market.cashiers.size() < index) {
                    for (int i = 1; i <= index - Market.cashiers.size(); i++) {
                        Cashier cashier = new Cashier(numofCahsier++);
                        Thread thread = new Thread(cashier);
                        Market.cashiers.put(thread, true);
                        thread.start();
                    }
                } else {
                    for (Map.Entry<Thread, Boolean> entry : Market.cashiers.entrySet()) {
                        if (count <= index) {
                            synchronized (entry.getKey()) {
                                entry.getKey().notify();
                                entry.setValue(true);
                                continue;
                            }
                        } else {
                            if (entry.getValue()) {
//                                System.out.println(entry.getKey()+" closed");
                                synchronized (entry.getKey()) {
                                    try {
                                        entry.getKey().wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                entry.setValue(false);
                            }
                        }
                        count++;
                    }
                }
            }
            if (buyers > 15 && buyers <= 20) {
                int index = 4;
                int count = 1;
                if (Market.cashiers.size() < index) {
                    for (int i = 1; i <= index - Market.cashiers.size(); i++) {
                        Cashier cashier = new Cashier(numofCahsier++);
                        Thread thread = new Thread(cashier);
                        Market.cashiers.put(thread, true);
                        thread.start();
                    }
                } else {
                    for (Map.Entry<Thread, Boolean> entry : Market.cashiers.entrySet()) {
                        if (count <= index) {
                            synchronized (entry.getKey()) {
                                entry.getKey().notify();
                                entry.setValue(true);
                                continue;
                            }
                        } else {
                            if (entry.getValue()) {
//                                System.out.println(entry.getKey()+" closed");
                                synchronized (entry.getKey()) {
                                    try {
                                        entry.getKey().wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                entry.setValue(false);
                            }
                        }
                        count++;
                    }
                }
            }
            if (buyers > 20) {
                int index = 5;
                int count = 1;
                if (Market.cashiers.size() < index) {
                    for (int i = 1; i <= index - Market.cashiers.size(); i++) {
                        Cashier cashier = new Cashier(numofCahsier++);
                        Thread thread = new Thread(cashier);
                        Market.cashiers.put(thread, true);
                        thread.start();
                    }
                } else {
                    for (Map.Entry<Thread, Boolean> entry : Market.cashiers.entrySet()) {
                        if (count <= index) {
                            synchronized (entry.getKey()) {
                                entry.getKey().notify();
                                entry.setValue(true);
                                continue;
                            }
                        } else {
                            if (!entry.getValue()) {
//                                System.out.println(entry.getKey()+" closed");
                                synchronized (entry.getKey()) {
                                    try {
                                        entry.getKey().wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                entry.setValue(false);
                            }
                        }
                        count++;
                    }
                }
            }
        }
    }
}
