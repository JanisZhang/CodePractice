package org.example.execute;

public interface RunnableQueue {
    void offer(Runnable runnable);

    Runnable take();

    int size();
}
