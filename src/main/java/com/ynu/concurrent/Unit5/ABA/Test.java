package com.ynu.concurrent.Unit5.ABA;

import org.springframework.util.Base64Utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 10:47
 **/
public class Test {



    static AtomicReference<String> reference = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {

        // 获取A的值,判断这个共享变量被它线程修改过？
        String prev = reference.get();

        //开两个线程,先把A改成B,再把B改成C
        other();
        TimeUnit.SECONDS.sleep(1);

        // 第三个线程修改变量想修改成C   成功了
        new Thread(()->{
            boolean issuccess = reference.compareAndSet(prev, "C");
            System.out.println("修改成功了吗?  "+ issuccess);
            System.out.println(reference.get());
        }).start();



    }

    private static void other() throws InterruptedException {

        new Thread(()->{
            reference.compareAndSet(reference.get(),"B");
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            reference.compareAndSet(reference.get(),"A");
        }).start();

    }

}
