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
@Slf4j(topic = "c.TestReentrantLock5")
public class TestReentrantLock5 {

    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 锁超时   立即返回
        Thread t1 = new Thread(()->{

            log.info("t1线程启动");
            try {
                if (!lock.tryLock(1,TimeUnit.SECONDS)){     // 超时获得锁失败
                    log.info("t1等待1s获取失败直接返回");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                log.info("t1线程获得了锁");
            }finally {
                lock.unlock();
            }

        },"t1");



        lock.lock();
        log.info("主线程获得了锁");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

}
