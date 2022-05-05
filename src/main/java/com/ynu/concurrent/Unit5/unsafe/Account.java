package com.ynu.concurrent.Unit5.unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-27 16:28
 **/
public interface Account {

    // 获取余额
    Integer getBanlance();

    // 取款
    void withdraw(Integer amount);

    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    static void demo(Account account){
        List<Thread> ts = new ArrayList<>();
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(()->{
                account.withdraw(10);
            }));
        }

        // 启动这一千个线程
        ts.forEach(Thread::start);

        // 主线程等待这些线程结束
        ts.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Long end = System.currentTimeMillis();
        System.out.println("花费时间:"+(end-start)+"ms"+" 余额为:"+account.getBanlance());


    }


}
