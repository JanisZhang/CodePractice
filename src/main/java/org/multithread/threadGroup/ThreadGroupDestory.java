package org.multithread.threadGroup;

import static java.lang.Thread.currentThread;

public class ThreadGroupDestory {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("ThreadGroup");

        ThreadGroup mainGroup = currentThread().getThreadGroup();
        System.out.println(group.isDestroyed());
        mainGroup.list();

        group.destroy();
        System.out.println(group.isDestroyed());
        mainGroup.list();
    }
}
