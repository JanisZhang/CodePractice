package org.multithread;

public class TicketWindowRunnable implements Runnable{
    private int index = 1;

    private static final int MAX = 500;

    private static final Object object = new Object();


    @Override
    public void run() {
        synchronized (object){
            while (index <= MAX){
                System.out.println("Current: " + Thread.currentThread().getName()+ ":" +
                        " " + (index++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable runnable = new TicketWindowRunnable();
        Thread thread1 = new Thread(runnable,"Counter one");
        Thread thread2 = new Thread(runnable,"Counter two");
        Thread thread3 = new Thread(runnable,"Counter three");
        Thread thread4 = new Thread(runnable,"Counter four");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
