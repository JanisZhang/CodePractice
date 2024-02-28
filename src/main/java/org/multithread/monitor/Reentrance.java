package org.multithread.monitor;

public class Reentrance {

    private int count =0;

    private synchronized void inc(){
        this.count++;
    }

    private synchronized int incAndGet(){
        inc();
        return this.count;
    }

    public static void main(String[] args) {
        Reentrance reentrance = new Reentrance();

        System.out.println(reentrance.incAndGet());
    }
}
