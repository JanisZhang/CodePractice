package org.example.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

public class BooleanLockTest {
    private final Lock lock = new BooleanLock();

    public void syncMethod(){
        try {
            lock.lock();

            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                lock.unLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void syncMethodTimeoutable(){
        try {
            lock.lock(1000);
            System.out.println(currentThread() + " get the lock.");
            int randomInt = current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                lock.unLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();
//        IntStream.range(0,10).mapToObj(i->new Thread(blt::syncMethod))
//                .forEach(Thread::start);

//        new Thread(blt::syncMethod,"T1").start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        Thread t2 = new Thread(blt::syncMethod,"T2");
//        t2.start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        t2.interrupt();

        new Thread(blt::syncMethod,"T1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t2 = new Thread(blt::syncMethodTimeoutable,"T2");
        t2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
