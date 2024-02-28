package org.multithread;

public class TemplateMethod {
    public static void main(String[] args) {

        TemplateMethod templateMethod1 = new TemplateMethod(){

            @Override
            public void wrapPrint(String message) {
                System.out.println("1111 print:" + message);
            }
        };

        templateMethod1.printMethod("child 1");

        TemplateMethod templateMethod2 = new TemplateMethod(){

            @Override
            public void wrapPrint(String message) {
                System.out.println("2222 print:" + message);
            }
        };

        templateMethod2.printMethod("child 2");

    }

    public void printMethod(String message){
        System.out.println("##########");
        wrapPrint(message);
        System.out.println("##########");
    }
    public void wrapPrint(String message){
    }

}