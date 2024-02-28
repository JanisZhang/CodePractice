package org.multithread.threadGroup;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup1 = new ThreadGroup("myGroup 1");
        ThreadGroup myGroup2 = new ThreadGroup(myGroup1,"myGroup 2");
        ThreadGroup myGroup3 = new ThreadGroup(myGroup2,"myGroup 3");

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = currentThread().getThreadGroup();

        ThreadGroup[] list = new ThreadGroup[mainGroup.activeGroupCount()];

        int recurseSize = myGroup1.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = myGroup1.enumerate(list,false);
        System.out.println(recurseSize);


    }
}
