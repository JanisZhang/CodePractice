package org.multithread.threadGroup;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDaemon {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group1 = new ThreadGroup("myGroup1");

        new Thread(group1,()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        },"MyThread1").start();

        ThreadGroup group2 = new ThreadGroup("myGroup2");

        new Thread(group2,()->{
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        },"MyThread2").start();

        group2.setDaemon(true);

        TimeUnit.SECONDS.sleep(3);
        System.out.println(group1.isDestroyed());
        System.out.println(group2.isDestroyed());

    }
}
