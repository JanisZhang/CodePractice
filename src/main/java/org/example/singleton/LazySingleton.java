package org.example.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){

    }

    // 在多线程的情况下不能保证单例的唯一性。
    private LazySingleton getInstance(){
        if(instance == null){
            instance =  new LazySingleton();
        }
        return instance;
    }

    // 加入synchronized关键字解决多线程情况下，单例唯一性的问题。
    // However， 效率低下。
    private synchronized LazySingleton getInstance2(){
        if(instance == null){
            instance =  new LazySingleton();
        }
        return instance;
    }



}
