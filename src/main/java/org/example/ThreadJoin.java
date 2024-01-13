package org.example;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads=
                IntStream.range(1,3).mapToObj(ThreadJoin::create).collect(Collectors.toList());

        threads.forEach(Thread::start);

        for(Thread thread:threads){
            thread.join();
        }

        //main thread
        for (int j=0;j<10;j++){
            System.out.println(Thread.currentThread().getName()+"#"+j);
            shortSleep();
        }

    }

    private static Thread create(int seq) {
        return new Thread(()->{
            for (int j=0;j<10;j++){
                System.out.println(Thread.currentThread().getName()+"#"+j);
                shortSleep();
            }
        },String.valueOf(seq));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
