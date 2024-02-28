package org.multithread;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

//        thread.setDaemon(true);

        thread.start();

        Thread.sleep(200_0L);
        System.out.println("Main Thread finished lifecycle");
    }
}
