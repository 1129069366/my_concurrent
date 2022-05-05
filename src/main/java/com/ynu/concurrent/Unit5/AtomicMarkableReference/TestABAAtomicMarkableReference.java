package com.ynu.concurrent.Unit5.AtomicMarkableReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 12:56
 **/
public class TestABAAtomicMarkableReference {

    public static void main(String[] args) throws InterruptedException {

        GarbageBag garbageBag = new GarbageBag("垃圾袋已经满了");// 参数2
        // mark 可以看作一个标记，表示垃圾袋满了 true表示满
        AtomicMarkableReference<GarbageBag> reference = new AtomicMarkableReference<>(garbageBag,true);
        System.out.println("主线程开始。。。");


        GarbageBag prev = reference.getReference();
        System.out.println(prev.toString());

//        // 倒垃圾线程
//        new Thread(()->{
//            System.out.println("打扫卫生的线程 start...");
//            garbageBag.setDesc("倒垃圾了，垃圾袋空了");
//
//            // 垃圾袋是满的  倒垃圾成功就退出循环了
//            while (!reference.compareAndSet(garbageBag,garbageBag,true,false)){
//
//            }
//
//            System.out.println(garbageBag.toString());
//
//        }).start();


        Thread.sleep(1000);
        System.out.println("主线程想换垃圾袋,必须是满的才换");
        boolean issuccess = reference.compareAndSet(prev, new GarbageBag("新垃圾袋"), true, false);
        System.out.println("换垃圾袋成功了吗? "+issuccess);


    }
}
