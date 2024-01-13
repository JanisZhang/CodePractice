package org.example;

public class ThreadConstruction {

    public static void main(String[] args) {
        Thread thread1 = new Thread("Thread 1");

        ThreadGroup threadGroup = new ThreadGroup("Test Thread Group");

        Thread thread2 = new Thread(threadGroup,"Thread 2");

        ThreadGroup mainThreadGroup =  Thread.currentThread().getThreadGroup();

        System.out.println("Main Thread belong group: "+ mainThreadGroup.getName());

        System.out.println("Thread 1 and main thread belong the same group : "+ (thread1.getThreadGroup()==mainThreadGroup));
        System.out.println("Thread 2 and main thread belong the same group : "+ (thread2.getThreadGroup()==mainThreadGroup));
        System.out.println("Thread 2 belong the test group : "+ (thread2.getThreadGroup()==threadGroup));
    }
}
