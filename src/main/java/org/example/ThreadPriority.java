package org.example;

import java.util.concurrent.TimeUnit;

public class ThreadPriority {

//    public static void main(String[] args) {
//        ThreadGroup threadGroup = new ThreadGroup("Test group");
//        threadGroup.setMaxPriority(7);
//        System.out.println("Priority of group: "+ threadGroup.getMaxPriority());
//
//        Thread thread = new Thread(threadGroup,"My Thread");
//        thread.setPriority(10);
//        System.out.println("current thread priority: "+ thread.getPriority());
//    }

//    public static void main(String[] args) {
//        Thread mainThread = Thread.currentThread();
//
//        System.out.println("Main thread priority is: "+mainThread.getPriority());
//
//        Thread thread = new Thread();
//
//        System.out.println(thread.getPriority());
//    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());

        Thread thread1 = new Thread("Thread 1");
        System.out.println("Thread1 ID: " + thread1.getId());

        Thread thread2 = new Thread("Thread 2");
        System.out.println("Thread2 ID: " + thread2.getId());
    }
}
