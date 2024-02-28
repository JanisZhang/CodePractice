package org.multithread;

public class SynchronizedCounter {

    private int count = 0;

//    private void inc(){
//        this.count++;
//    }
//
//    private int getCount(){
//        return count;
//    }

    private void inc(){
        synchronized (this){
            this.count++;
        }
    }

    private int getCount(){
        synchronized (this){
            return count;
        }
    }


    public static void main(String[] args) {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                synchronizedCounter.inc();
            }
            System.out.println(synchronizedCounter.getCount());
        });

        Thread thread2 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                synchronizedCounter.inc();
            }
            System.out.println(synchronizedCounter.getCount());
        });

        thread1.start();
        thread2.start();

        System.out.println(synchronizedCounter.getCount());
    }
}
