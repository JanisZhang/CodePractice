package org.eight;

public class MyTest {
    public static void main(String[] args) {
        System.out.println(cal());
    }

    static int cal(){
        try {
            return 4;
        }finally {
            return 3;
        }
    }
}
