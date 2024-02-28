package org.multithread;

public class TestWaitAndNotify {

//    private void testWait(){
//        try {
//            this.wait();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void testNotify(){
//        this.notify();
//    }

//    private synchronized void testWait(){
//        try {
//            this.wait();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private synchronized void testNotify(){
//        this.notify();
//    }
    final Object monitor = new Object();

    private void testWait(){
        synchronized (monitor){
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void testNotify(){
       synchronized (monitor){
           monitor.notify();
       }
    }

    public static void main(String[] args) throws InterruptedException {
        TestWaitAndNotify testWaitAndNotify = new TestWaitAndNotify();

        testWaitAndNotify.testWait();
    }
}
