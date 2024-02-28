package org.multithread.monitor;

public class MixedSynchronization {

//    private static final Object object = new Object();

    public static synchronized void setStaticObj(){
        for(int i = 0; i<10; i++){
            System.out.println("static -- "+i);
        }
    }


//    public static synchronized void setObj(){
//        for(int i = 11; i<20; i++){
//            System.out.println("static2 -- "+i);
//        }
//    }

//    public synchronized void setObj(){
//        for(int i = 11; i<20; i++){
//            System.out.println("non static -- "+i);
//        }
//    }

    public void setObj(){
        synchronized (this){
            for(int i = 0; i<10; i++){
                System.out.println("set obj -- "+i);
            }
        }
    }
    public void getObj(){
        synchronized (this){
            for(int i = 11; i<20; i++){
                System.out.println("get obj -- "+i);
            }
        }
    }


    public static void main(String[] args) {
//       Thread thread1 = new Thread(() -> {
//           MixedSynchronization mixedSynchronization =
//                   new MixedSynchronization();
//
//           mixedSynchronization.setObj();
//       });
//
//       Thread thread2 = new Thread(() -> {
//           MixedSynchronization mixedSynchronization =
//                   new MixedSynchronization();
//
//           mixedSynchronization.getObj();
//       });
//
//       thread1.start();
//       thread2.start();
    }
}
