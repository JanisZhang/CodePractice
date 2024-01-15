package org.example;

import java.util.concurrent.TimeUnit;

public class SynchronizedDefect {

    public synchronized void syncMethod(){
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        final  SynchronizedDefect synchronizedDefect = new SynchronizedDefect();
        Thread thread1 = new Thread(() -> synchronizedDefect.syncMethod(),"T1");
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread thread2 = new Thread(() -> synchronizedDefect.syncMethod(),"T2");
        thread2.start();
        thread2.interrupt();

        System.out.println(thread2.isInterrupted());
        System.out.println(thread2.getState());
    }
}
