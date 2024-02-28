package org.multithread;

public class ThreadJoin2 {

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(2000); // 线程A睡眠2秒钟
                System.out.println("线程A执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000); // 线程B睡眠1秒钟
                System.out.println("线程B执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start(); // 启动线程A
        threadB.start(); // 启动线程B

        try {
            threadA.join(); // 主线程等待线程A执行完成
            threadB.join(); // 主线程等待线程B执行完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完成");
    }
}
