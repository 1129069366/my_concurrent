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
@Slf4j(topic = "c.TestReentrantLock2")
public class TestReentrantLock2 {

    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 可打断
        Thread t1 = new Thread(()->{
            lock.lock();
            try {
                log.info("t1获得了锁");
            }finally {
                lock.unlock();
                log.info("t1释放锁");
            }
        },"t1");

        lock.lock();
        log.info("主线程获得了锁");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            t1.interrupt();
            log.info("执行打断");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
