package org.multithread.singleton;

public enum EnumSingleton {
    INSTANCE;

    private EnumSingleton(){

    }

    private EnumSingleton getInstance(){
        return INSTANCE;
    }
}
