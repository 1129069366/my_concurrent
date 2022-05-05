package com.ynu.concurrent.Unit5.AtomicReference;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-29 09:15
 **/
public interface DecimalAccount {

    /**
     * 获取余额
     * @return
     */
    BigDecimal getBalance();


    // 取款
    void withdraw(BigDecimal amount);


    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    static void demo(DecimalAccount account){
        List<Thread> ts = new ArrayList<>();

        Long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(()->{
                account.withdraw(BigDecimal.TEN);
            }));
        }
        ts.forEach(Thread::start);

        ts.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Long end = System.currentTimeMillis();

        System.out.println("花费时间为:"+(end-start)+"ms"+"余额为:" + account.getBalance());

    }



}
