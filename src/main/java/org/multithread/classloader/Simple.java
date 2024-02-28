package org.multithread.classloader;

public class Simple extends SImpleParent {
    static {
        System.out.println("I will be initialized.");
    }

    public static int x = 10;

    public static void test(){

    }
}
