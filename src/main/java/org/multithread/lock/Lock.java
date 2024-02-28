package org.multithread.lock;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Lock {

    void lock() throws InterruptedException;
    void lock(long time) throws InterruptedException, TimeoutException;
    void unLock() throws InterruptedException;

    List<Thread> getBlockedThreads();
}
