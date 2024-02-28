package org.multithread.event;

public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<100;i++){
                try {
                    eventQueue.offer2(new EventQueue.Event());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Producer");

        Thread thread2 = new Thread(() -> {
            for(int i=0;i<100;i++){
                eventQueue.take2();
            }
        },"Consumer");

        thread1.start();
        thread2.start();

        // test multiple threads
        Thread thread3 = new Thread(() -> {
            for(;;){
                eventQueue.take2();
            }
        },"Consumer");

        thread3.start();

    }


}
