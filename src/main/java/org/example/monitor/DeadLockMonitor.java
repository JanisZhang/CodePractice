package org.example.monitor;

import java.util.concurrent.TimeUnit;

public class DeadLockMonitor {
    private static Object object1 = new Object();

    private static Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            synchronized (object1){
                System.out.println("Thread 1: Holding lock 1");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 1: waiting lock 2");
                synchronized (object2){
                    System.out.println("Thread 1: Holding lock 1 and lock 2");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (object2){
                System.out.println("Thread 2: Holding lock 2");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 2: waiting lock 1");
                synchronized (object1){
                    System.out.println("Thread 2: Holding lock 1 and lock 2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
