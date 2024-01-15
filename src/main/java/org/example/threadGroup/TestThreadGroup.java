package org.example.threadGroup;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class TestThreadGroup {
    public static void main(String[] args) {
//        System.out.println(currentThread().getThreadGroup().getName());
//        Thread thread = new Thread(()-> System.out.println("t1"));
//        thread.start();
//        System.out.println(thread.getThreadGroup().getName());

        ThreadGroup threadGroup = currentThread().getThreadGroup();
        ThreadGroup threadGroup1 = new ThreadGroup("Group1");

        System.out.println(threadGroup1.getParent() == threadGroup);

        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"Group1's child");
        System.out.println(threadGroup2.getParent() == threadGroup1);
        System.out.println(threadGroup2.getParent() == threadGroup);

    }
}
