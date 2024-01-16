package org.example.execute;

@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
