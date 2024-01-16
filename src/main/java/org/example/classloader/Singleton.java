package org.example.classloader;

public class Singleton {

//    private static Singleton instance = new Singleton();
    private static int x = 0;
    private static int y ;

    private static Singleton instance = new Singleton();

    private Singleton(){
        x++;
        y++;
    }

    private static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
