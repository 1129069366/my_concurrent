package com.ynu.concurrent.Unit5.safe2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: my_concurrent
 * @description
 * @author: Mr.Yang
 * @create: 2022-03-27 16:41
 **/
public class AccountSafe implements Account {
    private AtomicInteger balance;

    public AccountSafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBanlance() {
        return this.balance.get();
    }


    @Override
    public void withdraw(Integer amount) {
        while (true){
            int prev = balance.get();
            int next = prev - amount;
            /*
             * compareAndSet 正是做这个检查，在 set 前，先比较 prev 与当前值
             * 不一致了，next 作废，返回 false 表示失败
             * 比如，别的线程已经做了减法，当前值已经被减成了 990
             * 那么本线程的这次 990 就作废了，进入 while 下次循环重试
             * 一致，以 next 设置为新值，返回 true 表示成功
             */
            if (balance.compareAndSet(prev,next)){
                break;
            }
        }
//        balance.addAndGet(-1*amount);
    }
}
