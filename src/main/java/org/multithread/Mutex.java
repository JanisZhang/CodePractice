package org.multithread;

import java.util.concurrent.TimeUnit;

public class Mutex {

    private static final Object mutex = new Object();

    public synchronized void accessResource(){
//        synchronized (mutex){

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//        }
    }

    public static void main(String[] args) {
        final Mutex mutex1 = new Mutex();

        for(int i=0;i<5;i++){
            new Thread(mutex1::synMethod).start();
        }


    }

    public synchronized void synMethod() {

    }
}
