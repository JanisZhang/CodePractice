package org.example;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(()-> {
//            try {
//                TimeUnit.MINUTES.sleep(2);
//            } catch (InterruptedException e) {
//                System.out.println("oh, i am be interrupted.");
//            }
//        });
//
//        thread.start();
//        TimeUnit.SECONDS.sleep(2);
//
//        thread.interrupt();
//
//        System.out.println("test");
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(()-> {
//            while(true){}
//        });
//
//        thread.start();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(thread.isInterrupted());
//        thread.interrupt();
//
//        System.out.println(thread.isInterrupted());
//    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(()-> {
//            while(true){
//                try {
//                    TimeUnit.MINUTES.sleep(2);
//                } catch (InterruptedException e) {
//                    System.out.printf("Am i being interrupted? --- %s \n ",
//                            Thread.currentThread().isInterrupted());
//                }
//            }
//        });
//        thread.setDaemon(true);
//
//        thread.start();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("This thread is interrupt? -- "+thread.isInterrupted());
//        thread.interrupt();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("This thread is interrupt? -- "+thread.isInterrupted());
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(()-> {
//            while(true){
//                System.out.println(Thread.interrupted());
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("This thread is interrupt? -- "+thread.isInterrupted());
//        thread.interrupt();
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("This thread is interrupt? -- "+thread.isInterrupted());
//    }



//    public static void main(String[] args) {
//        System.out.println("Main thread is interrupted? -- "+Thread.interrupted());
//
//        Thread.currentThread().interrupt();
//
//        System.out.println("Main thread is interrupted? -- "+Thread.currentThread().isInterrupted());
//
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            System.out.println("I will be interrupted still.");
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted? -- "+Thread.currentThread().isInterrupted());

        TimeUnit.SECONDS.sleep(2);

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted? -- "+Thread.currentThread().isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("I will be interrupted still.");
        }
    }
}
