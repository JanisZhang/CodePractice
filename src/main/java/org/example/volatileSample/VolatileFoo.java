package org.example.volatileSample;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {
    static volatile int init_value = 0;
    static int max_value = 5;

    public static void main(String[] args) {
        new Thread(()->{
            int local_value = init_value;

            while (local_value<max_value){
                if(init_value != local_value){
                    System.out.printf("The init_value is updated to [%d]\n",init_value);
                    local_value = init_value;
                }
            }
        },"Reader").start();

        new Thread(()->{
            int local_value = init_value;

            while (local_value< max_value){
                System.out.printf(" The value will be changed to [%d]\n", ++local_value);
                init_value = local_value;

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        },"Updater").start();
    }
}
