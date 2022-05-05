package com.ynu.concurrent.Unit3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-09 15:06
 **/
@Slf4j(topic = "c.TestReentrantLock6")
public class TestReentrantLock6 {

    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // 默认不公平锁
        log.info("主线程加锁");
        lock.lock();  // 主线程先获取锁

        for (int i = 0; i < 5000; i++) {
            new Thread(()->{
                lock.lock();   //去争抢锁
                try {
                    System.out.println(Thread.currentThread().getName() + " running...");
                }finally {
                    lock.unlock();
                }
            },"t"+i).start();
        }


        Thread.sleep(1000);  // 主线程休眠1s

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " start...");
            try {
                System.out.println(Thread.currentThread().getName() + " running...");
            }finally {
                lock.unlock();
            }

        },"争抢线程").start();


        log.info("主线程释放锁");
        lock.unlock();  // 这里主线释放锁后  上面500个线程和争抢线程就会开始抢   默认是不公平的 索引争抢线程有可能先输出


    }

}
