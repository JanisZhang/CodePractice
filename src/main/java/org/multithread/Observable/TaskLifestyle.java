package org.multithread.Observable;

public interface TaskLifestyle<T> {

    void onStart(Thread thread);
    void onRunning(Thread thread);
    void onFinish(Thread thread, T result);
    void onError(Thread thread, Exception e);
}
