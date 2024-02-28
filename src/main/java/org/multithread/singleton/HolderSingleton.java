package org.multithread.singleton;

public class HolderSingleton {
    private HolderSingleton(){

    }

    private HolderSingleton getInstance(){
          return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        private static HolderSingleton instance = new HolderSingleton();
    }
}
