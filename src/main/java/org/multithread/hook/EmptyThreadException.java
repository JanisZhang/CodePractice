package org.multithread.hook;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class EmptyThreadException {
    public static void main(String[] args) {
        ThreadGroup mainGroup = currentThread().getThreadGroup();

        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());

        final Thread thread = new Thread(mainGroup,()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println(1/0);
        },"Test-Thread");

        thread.start();
    }
}
