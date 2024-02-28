package org.multithread.threadGroup;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class ThreadGroupBasic {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("group1");
        Thread thread = new Thread(threadGroup,()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"thread");
        thread.setDaemon(true);
        thread.start();

        //make sure the thread is started
        TimeUnit.MILLISECONDS.sleep(1);

        ThreadGroup mainGroup = currentThread().getThreadGroup();

        System.out.println("activeCount= "+mainGroup.activeCount());
        System.out.println("activeGroupCount= "+mainGroup.activeGroupCount());
        System.out.println("getMaxPriority = " + mainGroup.getMaxPriority());
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        mainGroup.list();
        System.out.println("-----------------------");
        System.out.println(mainGroup.parentOf(threadGroup));
        System.out.println(mainGroup.parentOf(mainGroup));
    }
}
