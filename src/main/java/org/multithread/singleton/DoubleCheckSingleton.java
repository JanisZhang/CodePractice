package org.multithread.singleton;

public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){

    }

    //解决sync关键字效率低下的问题， 只在首次初始化时候加锁。
    // However 指令重排序可能会引起NPE问题。
    private DoubleCheckSingleton getInstance(){
        if(null == instance){
            synchronized (this){
                if(null== instance){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }


    //阻止指令重排序。
    private static volatile DoubleCheckSingleton volatileInstance;
}
