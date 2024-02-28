package org.multithread;

import java.util.stream.IntStream;

public class ThreadYield {

    public static void main(String[] args) {
        IntStream.range(0,3).mapToObj(ThreadYield::create).forEach(Thread::start);


    }

    private static Thread create(int i) {
        return new Thread(() ->
        {
            if(i==1){
                Thread.yield();
            }
            System.out.println(i);
        }
        );
    }


}
