package org.multithread.execute;

@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
