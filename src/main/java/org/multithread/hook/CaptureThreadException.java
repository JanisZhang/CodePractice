package org.multithread.hook;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class CaptureThreadException {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(((t, e) -> {
            System.out.println(t.getName()+" occur exception");
            e.printStackTrace();
        }));
        ThreadGroup mainGroup = currentThread().getThreadGroup();

        final Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
            System.out.println(1/0);
        },"Test-Thread");

        thread.start();
    }
}
