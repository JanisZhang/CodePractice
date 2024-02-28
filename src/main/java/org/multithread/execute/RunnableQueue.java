package org.multithread.execute;

public interface RunnableQueue {
    void offer(Runnable runnable);

    Runnable take();

    int size();
}
