package com.ynu.concurrent.Unit4;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-04-19 16:11
 **/
public class TestHappesBefore {

    static int x = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread t2 = new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println(x);
                    break;
                }
            }
        });

        t2.start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x = 10;
            t2.interrupt();
        },"t1").start();

        while (!t2.isInterrupted()){
                                      // t2没被打断的时候就是死循环   不会往下走
        }

        System.out.println(x);


//        new Thread(()->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            x = 10;
//
//        },"t1").start();
//
//
//        new Thread(()->{
//           while (true){
//               System.out.println(x);
//           }
//        },"t2").start();



//        new Thread(()->{
//            synchronized (m){
//                x = 10;
//            }
//        },"t1").start();
//
//        Thread.sleep(100);
//
//        new Thread(()->{
//            synchronized (m){
//                System.out.println(x);
//            }
//        },"t2").start();



    }

}
