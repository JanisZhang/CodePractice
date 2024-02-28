package org.multithread.monitor;

public class SharedMonitorObject {
    private Object monitor = null;

    private int counter = 0;

    public SharedMonitorObject(Object object){
        this.monitor = object;
    }

    private void incCounter(){

        synchronized (this.monitor){
            this.counter++;
        }
    }

    private int getCounter(){
        return counter;
    }

    public static void main(String[] args) {
//        Object monitor1 = new Object();
//        SharedMonitorObject sharedMonitorObject1 =
//                new SharedMonitorObject(monitor1);
//
//        SharedMonitorObject sharedMonitorObject2 =
//                new SharedMonitorObject(monitor1);
    }
}
