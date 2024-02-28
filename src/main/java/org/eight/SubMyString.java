package org.eight;

public class SubMyString extends MyString{
    public static void main(String[] args) {
       new SubMyString().test();
    }
    public void test(){
        System.out.println(super.getClass().getName());
    }
}
