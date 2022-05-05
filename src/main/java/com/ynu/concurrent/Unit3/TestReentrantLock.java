package com.ynu.concurrent.Unit3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-09 15:06
 **/
@Slf4j(topic = "c.TestReentrantLock")
public class TestReentrantLock {

    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        // 可重入特性
        method1();

    }

    public static void method1(){

        lock.lock();
        try {
            log.info("method1");
           method2();
        }finally {
            lock.unlock();
        }

    }

    private static void method2() {
        lock.lock();
        try {
            log.info("method2");
            method3();
        }finally {
            lock.unlock();
        }
    }

    private static void method3() {
        lock.lock();
        try {
            log.info("method3");
        }finally {
            lock.unlock();
        }
    }


}
