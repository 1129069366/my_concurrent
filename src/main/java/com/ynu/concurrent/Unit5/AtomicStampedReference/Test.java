package com.ynu.concurrent.Unit5.AtomicStampedReference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 11:01
 **/
public class Test {

    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A",0);

    public static void main(String[] args) throws InterruptedException {

        // 获取值A
        String prev = ref.getReference();
        // 获取版本号
        int stamp = ref.getStamp();

        // 别的线程干扰
        other();


        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            System.out.println("把A改成C");
            boolean issuccess = ref.compareAndSet(prev, "C", stamp, stamp + 1);
            System.out.println("是否修改成功 "+ issuccess);
        }).start();

    }

    private static void other() throws InterruptedException {

        new Thread(()->{
            System.out.println("把A改成B");
            ref.compareAndSet(ref.getReference(),"B",ref.getStamp(),ref.getStamp()+1);
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            System.out.println("把B改成A");
            ref.compareAndSet(ref.getReference(),"A",ref.getStamp(),ref.getStamp()+1);
        }).start();


    }

}
