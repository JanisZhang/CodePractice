package org.multithread.singleton;

public class SimpleSingleton {

    private static SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton(){

    }

    private SimpleSingleton getInstance(){
        return instance;
    }
}
